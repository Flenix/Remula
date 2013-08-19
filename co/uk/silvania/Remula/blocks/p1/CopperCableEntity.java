package co.uk.silvania.Remula.blocks.p1;

import net.minecraft.tileentity.TileEntity;

public class CopperCableEntity extends TileEntity {
	
	public boolean[] touchingBlocks;
	
	public void CableLink() {
		touchingBlocks = new boolean[6];
	}

}
