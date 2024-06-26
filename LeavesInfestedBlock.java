package net.kustik.nahuy.block;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.kustik.nahuy.data.NahuyItemGroup;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.LeavesBlock;
import net.minecraft.block.Material;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.util.math.random.Random;

public class LeavesInfestedBlock extends LeavesBlock {

    private static final int MAX_AGE = 6000;
    public static final IntProperty AGE = IntProperty.of("age", 0, MAX_AGE);

    public LeavesInfestedBlock(){
        super(FabricBlockSettings.of(Material.LEAVES).sounds(BlockSoundGroup.GRASS));
        this.setDefaultState(this.stateManager.getDefaultState().with(AGE, 0));
    }

    @Override
    public void onPlaced(World world, BlockPos pos, BlockState state, LivingEntity placer, ItemStack itemStack){
        super.onPlaced(world, pos, state, placer, itemStack);
        state = state.with(AGE, 0);
        world.setBlockState(pos, state, 3);
        if (!world.isClient){
            world.scheduleBlockTick(pos, this, 20);
        }
    }

    @Override
    public void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random){
        super.scheduledTick(state, world, pos, random);

        if (state.contains(AGE)){
            int age = state.get(AGE);

            if (age < MAX_AGE) {
                world.setBlockState(pos, state.with(AGE, age +1), 3);
                world.scheduleBlockTick(pos, this, 20);
            } else {
                world.setBlockState(pos, state.with(AGE, 0), 3);
            }
        }
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder){
        builder.add(AGE);
    }

    public static final Block LEAVES_INFESTED_BLOCK = BaseBlock.registerBlock("leaves_infested_block",
            new LeavesInfestedBlock());

    public static void register(){
        NahuyItemGroup.addToGroups(LEAVES_INFESTED_BLOCK.asItem(), NahuyItemGroup.EX_NIHILO);
    }
}
