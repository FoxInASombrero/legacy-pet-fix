package hu.szviktor.plugins.petfix.listeners;

import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Ocelot;
import org.bukkit.entity.Tameable;
import org.bukkit.entity.Wolf;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityTeleportEvent;
import org.jetbrains.annotations.NotNull;

public class EntityListener implements Listener {

	@EventHandler
	public void onEntityTeleport(@NotNull EntityTeleportEvent event) {
		if (!(event.getEntity() instanceof LivingEntity))
			return;

		LivingEntity entity = (LivingEntity) event.getEntity();

		if (!(entity instanceof Tameable))
			return;

		Tameable tameable = (Tameable) entity;

		if (!tameable.isTamed())
			return;

		boolean sitting = false;

		if (entity instanceof Wolf)
			sitting = ((Wolf) entity).isSitting();

		if (entity instanceof Ocelot)
			sitting = ((Ocelot) entity).isSitting();

		event.setCancelled(sitting);
	}

}
