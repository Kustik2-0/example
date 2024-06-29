package net.kustik.nahuy.entities;

import net.kustik.nahuy.block.LeavesInfestedBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import static net.kustik.nahuy.block.LeavesInfestedBlock.LEAVES_INFESTED_BLOCK_ENTITY;

public class LeavesInfestedBlockEntity extends BlockEntity {
    private int ticks = 0;
    private boolean isFading = false;

    public LeavesInfestedBlockEntity(BlockPos pos, BlockState state) {
        super(LEAVES_INFESTED_BLOCK_ENTITY, pos, state);
    }

    public void startColorFade(){
        isFading = true;
        ticks = 0;
    }

    public static void tick(World world, BlockPos pos, BlockState state, LeavesInfestedBlockEntity blockEntity){
        if (blockEntity.isFading){
            blockEntity.ticks++;

            int fadeProgress = Math.min(blockEntity.ticks / 600, 10);
            world.setBlockState(pos, state.with(LeavesInfestedBlock.FADE_PROGRESS, fadeProgress));

            if (blockEntity.ticks >= 6000){
                blockEntity.isFading = false;
            }
        }
    }

    @Override
    public void readNbt(NbtCompound tag){
        super.readNbt(tag);
        isFading = tag.getBoolean("IsFading");
        ticks = tag.getInt("Ticks");
    }

    @Override
    public void writeNbt(NbtCompound tag){
        super.writeNbt(tag);
        tag.putBoolean("IsFading", isFading);
        tag.putInt("Ticks", ticks);
    }
}