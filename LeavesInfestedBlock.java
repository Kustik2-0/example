package net.kustik.nahuy.block;

import net.kustik.nahuy.Nahuy;
import net.kustik.nahuy.data.NahuyItemGroup;
import net.kustik.nahuy.entities.LeavesInfestedBlockEntity;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.util.math.random.Random;

public class LeavesInfestedBlock extends LeavesBlock implements BlockEntityProvider {

    public static final IntProperty FADE_PROGRESS = IntProperty.of("fade_progress", 0, 10);


    public LeavesInfestedBlock(){
        super(Settings.copy(Blocks.OAK_LEAVES));
        this.setDefaultState(this.getDefaultState().with(FADE_PROGRESS, 0));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder){
        super.appendProperties(builder);
        builder.add(FADE_PROGRESS);
    }

    @Override
    public void onPlaced(World world, BlockPos pos, BlockState state, LivingEntity placer, ItemStack itemStack){
        super.onPlaced(world, pos, state, placer, itemStack);

        if(!world.isClient){
            scheduledTick((ServerWorld) world, pos);
        }
    }

    private void scheduledTick(ServerWorld world, BlockPos pos){
        world.scheduleBlockTick(pos, this, 6000);
    }

    @Override
    public void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random){
        super.scheduledTick(state, world, pos, random);

        BlockEntity blockEntity = world.getBlockEntity(pos);
        if (blockEntity instanceof LeavesInfestedBlockEntity){
            ((LeavesInfestedBlockEntity) blockEntity).startColorFade();
        }
    }

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state){
        return new LeavesInfestedBlockEntity(pos, state);
    }

    @Override
    public <T extends BlockEntity>BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type){
        return world.isClient ? null : (BlockEntityTicker<T>) (world1, pos, state1, blockEntity) -> {
            if (blockEntity instanceof LeavesInfestedBlockEntity) {
                LeavesInfestedBlockEntity.tick(world1, pos, state1, (LeavesInfestedBlockEntity) blockEntity);
            }
        };
    }

    public static final Block LEAVES_INFESTED_BLOCK = BaseBlock.registerBlock("leaves_infested_block", new LeavesInfestedBlock());
    public static BlockEntityType<LeavesInfestedBlockEntity> LEAVES_INFESTED_BLOCK_ENTITY;

    public static void register(){
        NahuyItemGroup.addToGroups(LEAVES_INFESTED_BLOCK.asItem(), NahuyItemGroup.EX_NIHILO);
        LEAVES_INFESTED_BLOCK_ENTITY = Registry.register(
                Registries.BLOCK_ENTITY_TYPE,
                new Identifier(Nahuy.MOD_ID, "leaves_infested_block_entity"),
                BlockEntityType.Builder.create(LeavesInfestedBlockEntity::new, LEAVES_INFESTED_BLOCK).build(null)
        );
    }
}
