package co.uk.silvania.Remula.client.overlays;

import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.EventPriority;
import net.minecraftforge.event.ForgeSubscribe;

public class ThirstEventReciever {
	
	@ForgeSubscribe(priority = EventPriority.NORMAL)
	public void eventHandler(RenderGameOverlayEvent event) {
		
		MinecraftForge.EVENT_BUS.register(new ThirstEventReciever());
	}
}
