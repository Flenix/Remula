package co.uk.silvania.Remula.dimensions;

import co.uk.silvania.Remula.Remula;
import co.uk.silvania.Remula.RemulaBlocks;
import co.uk.silvania.Remula.blocks.RubberSapling;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.player.BonemealEvent;

public class RubberTreeBonemealEvent {
	
	private int BlockID;

	@ForgeSubscribe
	public void bonemealUsed(BonemealEvent event) {
		if(event.world.getBlockId(event.X, event.Y, event.Z) == RemulaBlocks.rubberSapling.blockID) {
			((RubberSapling)RemulaBlocks.rubberSapling).growTree(event.world, event.X, event.Y, event.Z, event.world.rand);
		}
	}
}
