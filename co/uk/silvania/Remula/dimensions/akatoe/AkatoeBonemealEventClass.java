package co.uk.silvania.Remula.dimensions.akatoe;

import co.uk.silvania.Remula.Remula;
import co.uk.silvania.Remula.blocks.p2.AkatoeSaplings;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.player.BonemealEvent;

public class AkatoeBonemealEventClass {
	
	private int BlockID;

	@ForgeSubscribe
	public void bonemealUsed(BonemealEvent event) {
		if(event.world.getBlockId(event.X, event.Y, event.Z) == Remula.akatoeSaplings.blockID) {
			((AkatoeSaplings)Remula.akatoeSaplings).growTree(event.world, event.X, event.Y, event.Z, event.world.rand);
		}
	}
}
