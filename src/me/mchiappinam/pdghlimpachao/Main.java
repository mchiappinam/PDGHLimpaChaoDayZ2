package me.mchiappinam.pdghlimpachao;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.ExperienceOrb;
import org.bukkit.entity.FallingBlock;
import org.bukkit.entity.Item;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.entity.Tameable;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockFormEvent;
import org.bukkit.event.block.LeavesDecayEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.entity.ExplosionPrimeEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {

	  public void onEnable() {
		getServer().getConsoleSender().sendMessage("§3[PDGHLimpaChao] §2registrando os eventos...");
		getServer().getPluginManager().registerEvents(this, this);
		getServer().getConsoleSender().sendMessage("§3[PDGHLimpaChao] §2eventos registrados com sucesso");
		getServer().getConsoleSender().sendMessage("§3[PDGHLimpaChao] §2ativando schedulers...");
    	getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
    		public void run() {
    	        for (World world : getServer().getWorlds()) {
    	            int removed = 0;

    	            for (Entity entity : world.getEntities()) {
    	                if (isIntensiveEntity(entity)) {
    	                    entity.remove();
    	                    removed++;
    	                }
    	            }
    	            //if (removed > 0) { //Coloquei como anotação para mostrar todos os mundos.
    	            	getServer().getConsoleSender().sendMessage("§3[PDGHLimpaChao] §c"+removed+" §2entidades eliminadas com sucesso no mundo §c"+world.getName());
    	            //}
    	        }
	      }
	    }, 100L);
    	IniciarTimers();
		getServer().getConsoleSender().sendMessage("§3[PDGHLimpaChao] §2schedulers ativados");
		getServer().getConsoleSender().sendMessage("§3[PDGHLimpaChao] §2ativado - Plugin by: mchiappinam");
		getServer().getConsoleSender().sendMessage("§3[PDGHLimpaChao] §2Acesse: http://pdgh.net/");
	  }
	    
	  public void onDisable() {
		getServer().getConsoleSender().sendMessage("§3[PDGHLimpaChao] §2desativado - Plugin by: mchiappinam");
		getServer().getConsoleSender().sendMessage("§3[PDGHLimpaChao] §2Acesse: http://pdgh.net/");
	  }

	    public static boolean isIntensiveEntity(Entity entity) {
	        return entity instanceof Item
	                || entity instanceof TNTPrimed
	                || entity instanceof ExperienceOrb
	                || entity instanceof FallingBlock
	                || (entity instanceof LivingEntity
	                    && !(entity instanceof Tameable)
	                    && !(entity instanceof Player));
	    }

	    @EventHandler(priority = EventPriority.HIGH, ignoreCancelled = true)
	    public void onExplosionPrime(ExplosionPrimeEvent e) {
	        Entity ent = e.getEntity();
            ent.remove();
            e.setCancelled(true);
            return;
	    }
	    
	    @EventHandler(priority = EventPriority.HIGH, ignoreCancelled = true)
	    public void onEntityExplode(EntityExplodeEvent e) {
	        Entity ent = e.getEntity();
            if (ent != null) {
                ent.remove();
            }
            e.setCancelled(true);
            return;
	    }

	    @EventHandler(priority = EventPriority.HIGH, ignoreCancelled = true)
	    public void onLeavesDecay(LeavesDecayEvent e) {
	            e.setCancelled(true);
	            return;
	    }

	    @EventHandler(priority = EventPriority.HIGH, ignoreCancelled = true)
	    public void onBlockForm(BlockFormEvent e) {
	            e.setCancelled(true);
	            return;
	    }
	    
	    public void Alerta20Seg() {
	    	getServer().broadcastMessage("§d[Ⓐⓛⓔⓡⓣⓐ] "+ChatColor.BOLD+"➜ §dLimpando itens/mobs do chão em 20 segundos");
	    	Alerta5Seg();
	    }
	    
	    public void Alerta5Seg() {
	    	getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
	    		public void run() {
	    	    	getServer().broadcastMessage("§d[Ⓐⓛⓔⓡⓣⓐ] "+ChatColor.BOLD+"➜ §dLimpando itens/mobs do chão em 5 segundos");
	    	    	ExecutarLimpeza();
		      }
		    }, 300L);
	    }
	    
	    public void SpawnMobs() {
	    	getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
	    		public void run() {
	    	    	getServer().broadcastMessage("§d[Ⓐⓛⓔⓡⓣⓐ] "+ChatColor.BOLD+"➜ §9Mobs nascendo no §c/warp end §9e §c/warp jogar1§9...");
	    	    	getServer().getWorld("world").spawnEntity(new Location(null, -227.5, 71.5, 379.5), EntityType.ZOMBIE);
	    	    	getServer().getWorld("world").spawnEntity(new Location(null, -227.5, 71.5, 379.5), EntityType.ZOMBIE);
	    	    	getServer().getWorld("world").spawnEntity(new Location(null, -227.5, 71.5, 379.5), EntityType.ZOMBIE);
	    	    	getServer().getWorld("world").spawnEntity(new Location(null, -227.5, 71.5, 379.5), EntityType.ZOMBIE);
	    	    	getServer().getWorld("world").spawnEntity(new Location(null, -227.5, 71.5, 379.5), EntityType.ZOMBIE);
	    	    	getServer().getWorld("world").spawnEntity(new Location(null, -227.5, 71.5, 379.5), EntityType.ZOMBIE);
	    	    	getServer().getWorld("world").spawnEntity(new Location(null, -227.5, 71.5, 379.5), EntityType.ZOMBIE);
	    	    	getServer().getWorld("world").spawnEntity(new Location(null, -227.5, 71.5, 379.5), EntityType.ZOMBIE);
	    	    	getServer().getWorld("world").spawnEntity(new Location(null, -227.5, 71.5, 379.5), EntityType.ZOMBIE);
	    	    	getServer().getWorld("world").spawnEntity(new Location(null, -227.5, 71.5, 379.5), EntityType.ZOMBIE);
	    	    	getServer().getWorld("world").spawnEntity(new Location(null, -227.5, 71.5, 379.5), EntityType.ZOMBIE);
	    	    	getServer().getWorld("world").spawnEntity(new Location(null, -227.5, 71.5, 379.5), EntityType.ZOMBIE);
	    	    	getServer().getWorld("world").spawnEntity(new Location(null, -227.5, 71.5, 379.5), EntityType.ZOMBIE);
	    	    	getServer().getWorld("world").spawnEntity(new Location(null, -227.5, 71.5, 379.5), EntityType.ZOMBIE);
	    	    	getServer().getWorld("world").spawnEntity(new Location(null, -227.5, 71.5, 379.5), EntityType.ZOMBIE);
	    	    	getServer().getWorld("world").spawnEntity(new Location(null, -227.5, 71.5, 379.5), EntityType.ZOMBIE);
	    	    	getServer().getWorld("world").spawnEntity(new Location(null, -227.5, 71.5, 379.5), EntityType.ZOMBIE);
	    	    	getServer().getWorld("world").spawnEntity(new Location(null, -227.5, 71.5, 379.5), EntityType.ZOMBIE);
	    	    	getServer().getWorld("world").spawnEntity(new Location(null, -227.5, 71.5, 379.5), EntityType.ZOMBIE);
	    	    	getServer().getWorld("world").spawnEntity(new Location(null, -227.5, 71.5, 379.5), EntityType.ZOMBIE);
	    	    	getServer().getWorld("world").spawnEntity(new Location(null, -227.5, 71.5, 379.5), EntityType.ZOMBIE);
	    	    	getServer().getWorld("world").spawnEntity(new Location(null, -227.5, 71.5, 379.5), EntityType.ZOMBIE);
	    	    	getServer().getWorld("world").spawnEntity(new Location(null, -227.5, 71.5, 379.5), EntityType.ZOMBIE);
	    	    	getServer().getWorld("world").spawnEntity(new Location(null, -227.5, 71.5, 379.5), EntityType.ZOMBIE);
	    	    	getServer().getWorld("world").spawnEntity(new Location(null, -227.5, 71.5, 379.5), EntityType.ZOMBIE);
	    	    	getServer().getWorld("world").spawnEntity(new Location(null, -227.5, 71.5, 379.5), EntityType.ZOMBIE);
	    	    	getServer().getWorld("world").spawnEntity(new Location(null, -227.5, 71.5, 379.5), EntityType.ZOMBIE);
	    	    	getServer().getWorld("world").spawnEntity(new Location(null, -227.5, 71.5, 379.5), EntityType.ZOMBIE);
	    	    	getServer().getWorld("world").spawnEntity(new Location(null, -227.5, 71.5, 379.5), EntityType.ZOMBIE);
	    	    	getServer().getWorld("world").spawnEntity(new Location(null, -227.5, 71.5, 379.5), EntityType.ZOMBIE);
	    	    	getServer().getWorld("world").spawnEntity(new Location(null, -227.5, 71.5, 379.5), EntityType.ZOMBIE);
	    	    	getServer().getWorld("world").spawnEntity(new Location(null, -227.5, 71.5, 379.5), EntityType.ZOMBIE);
	    	    	getServer().getWorld("world").spawnEntity(new Location(null, -227.5, 71.5, 379.5), EntityType.ZOMBIE);
	    	    	getServer().getWorld("world").spawnEntity(new Location(null, -227.5, 71.5, 379.5), EntityType.ZOMBIE);
	    	    	getServer().getWorld("world").spawnEntity(new Location(null, -227.5, 71.5, 379.5), EntityType.ZOMBIE);
	    	    	getServer().getWorld("world").spawnEntity(new Location(null, -227.5, 71.5, 379.5), EntityType.ZOMBIE);
	    	    	getServer().getWorld("world").spawnEntity(new Location(null, -227.5, 71.5, 379.5), EntityType.ZOMBIE);
	    	    	getServer().getWorld("world").spawnEntity(new Location(null, -227.5, 71.5, 379.5), EntityType.ZOMBIE);
	    	    	getServer().getWorld("world").spawnEntity(new Location(null, -227.5, 71.5, 379.5), EntityType.ZOMBIE);
	    	    	getServer().getWorld("world").spawnEntity(new Location(null, -227.5, 71.5, 379.5), EntityType.ZOMBIE);
	    	    	getServer().getWorld("world_the_end").spawnEntity(new Location(null, 18.5, 64.5, -18.5), EntityType.ZOMBIE);
	    	    	getServer().getWorld("world_the_end").spawnEntity(new Location(null, 18.5, 64.5, -18.5), EntityType.ZOMBIE);
	    	    	getServer().getWorld("world_the_end").spawnEntity(new Location(null, 18.5, 64.5, -18.5), EntityType.ZOMBIE);
	    	    	getServer().getWorld("world_the_end").spawnEntity(new Location(null, 18.5, 64.5, -18.5), EntityType.ZOMBIE);
	    	    	getServer().getWorld("world_the_end").spawnEntity(new Location(null, 18.5, 64.5, -18.5), EntityType.ZOMBIE);
	    	    	getServer().getWorld("world_the_end").spawnEntity(new Location(null, 18.5, 64.5, -18.5), EntityType.ZOMBIE);
	    	    	getServer().getWorld("world_the_end").spawnEntity(new Location(null, 18.5, 64.5, -18.5), EntityType.ZOMBIE);
	    	    	getServer().getWorld("world_the_end").spawnEntity(new Location(null, 18.5, 64.5, -18.5), EntityType.ZOMBIE);
	    	    	getServer().getWorld("world_the_end").spawnEntity(new Location(null, 18.5, 64.5, -18.5), EntityType.ZOMBIE);
	    	    	getServer().getWorld("world_the_end").spawnEntity(new Location(null, 18.5, 64.5, -18.5), EntityType.ZOMBIE);
	    	    	getServer().getWorld("world_the_end").spawnEntity(new Location(null, 18.5, 64.5, -18.5), EntityType.ZOMBIE);
	    	    	getServer().getWorld("world_the_end").spawnEntity(new Location(null, 18.5, 64.5, -18.5), EntityType.ZOMBIE);
	    	    	getServer().getWorld("world_the_end").spawnEntity(new Location(null, 18.5, 64.5, -18.5), EntityType.ZOMBIE);
	    	    	getServer().getWorld("world_the_end").spawnEntity(new Location(null, 18.5, 64.5, -18.5), EntityType.ZOMBIE);
	    	    	getServer().getWorld("world_the_end").spawnEntity(new Location(null, 18.5, 64.5, -18.5), EntityType.ZOMBIE);
	    	    	getServer().getWorld("world_the_end").spawnEntity(new Location(null, 18.5, 64.5, -18.5), EntityType.ZOMBIE);
	    	    	getServer().getWorld("world_the_end").spawnEntity(new Location(null, 18.5, 64.5, -18.5), EntityType.ZOMBIE);
	    	    	getServer().getWorld("world_the_end").spawnEntity(new Location(null, 18.5, 64.5, -18.5), EntityType.ZOMBIE);
	    	    	getServer().getWorld("world_the_end").spawnEntity(new Location(null, 18.5, 64.5, -18.5), EntityType.ZOMBIE);
	    	    	getServer().getWorld("world_the_end").spawnEntity(new Location(null, 18.5, 64.5, -18.5), EntityType.ZOMBIE);
	    	    	getServer().getWorld("world_the_end").spawnEntity(new Location(null, 18.5, 64.5, -18.5), EntityType.ZOMBIE);
	    	    	getServer().getWorld("world_the_end").spawnEntity(new Location(null, 18.5, 64.5, -18.5), EntityType.ZOMBIE);
	    	    	getServer().getWorld("world_the_end").spawnEntity(new Location(null, 18.5, 64.5, -18.5), EntityType.ZOMBIE);
	    	    	getServer().getWorld("world_the_end").spawnEntity(new Location(null, 18.5, 64.5, -18.5), EntityType.ZOMBIE);
	    	    	getServer().getWorld("world_the_end").spawnEntity(new Location(null, 18.5, 64.5, -18.5), EntityType.ZOMBIE);
	    	    	getServer().getWorld("world_the_end").spawnEntity(new Location(null, 18.5, 64.5, -18.5), EntityType.ZOMBIE);
	    	    	getServer().getWorld("world_the_end").spawnEntity(new Location(null, 18.5, 64.5, -18.5), EntityType.ZOMBIE);
	    	    	getServer().getWorld("world_the_end").spawnEntity(new Location(null, 18.5, 64.5, -18.5), EntityType.ZOMBIE);
	    	    	getServer().getWorld("world_the_end").spawnEntity(new Location(null, 18.5, 64.5, -18.5), EntityType.ZOMBIE);
	    	    	getServer().getWorld("world_the_end").spawnEntity(new Location(null, 18.5, 64.5, -18.5), EntityType.ZOMBIE);
	    	    	getServer().getWorld("world_the_end").spawnEntity(new Location(null, 18.5, 64.5, -18.5), EntityType.ZOMBIE);
	    	    	getServer().getWorld("world_the_end").spawnEntity(new Location(null, 18.5, 64.5, -18.5), EntityType.ZOMBIE);
	    	    	getServer().getWorld("world_the_end").spawnEntity(new Location(null, 18.5, 64.5, -18.5), EntityType.ZOMBIE);
	    	    	getServer().getWorld("world_the_end").spawnEntity(new Location(null, 18.5, 64.5, -18.5), EntityType.ZOMBIE);
	    	    	getServer().getWorld("world_the_end").spawnEntity(new Location(null, 18.5, 64.5, -18.5), EntityType.ZOMBIE);
	    	    	getServer().getWorld("world_the_end").spawnEntity(new Location(null, 18.5, 64.5, -18.5), EntityType.ZOMBIE);
	    	    	getServer().getWorld("world_the_end").spawnEntity(new Location(null, 18.5, 64.5, -18.5), EntityType.ZOMBIE);
	    	    	getServer().getWorld("world_the_end").spawnEntity(new Location(null, 18.5, 64.5, -18.5), EntityType.ZOMBIE);
	    	    	getServer().getWorld("world_the_end").spawnEntity(new Location(null, 18.5, 64.5, -18.5), EntityType.ZOMBIE);
	    	    	getServer().getWorld("world_the_end").spawnEntity(new Location(null, 18.5, 64.5, -18.5), EntityType.ZOMBIE);
		      }
		    }, 100L);
	    }
	    
	    public void ExecutarLimpeza() {
	    	getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
	    		public void run() {
	    	        int removed = 0;
	    	        for (World world : getServer().getWorlds()) {

	    	            for (Entity entity : world.getEntities()) {
	    	                if (isIntensiveEntity(entity)) {
	    	                    entity.remove();
	    	                    removed++;
	    	                }
	    	            }

		    	    	//getServer().broadcastMessage("§d[Ⓐⓛⓔⓡⓣⓐ] "+ChatColor.BOLD+"➜ §dLimpando itens/mobs do chão em 5 segundos");
	    	            //if (removed > 0) { //Coloquei como anotação para mostrar todos os mundos.
	    	            	//getServer().getConsoleSender().sendMessage("§3[PDGHLimpaChao] §c"+removed+" §2entidades eliminadas com sucesso no mundo §c"+world.getName());
	    	            //}
	    	        }
	    	    	//getServer().broadcastMessage("§d[Ⓐⓛⓔⓡⓣⓐ] "+ChatColor.BOLD+"➜ §d"+removed+" entidades removidas.");
	    	        me.mchiappinam.pdghloot.Main.spawn((me.mchiappinam.pdghloot.Main) Bukkit.getPluginManager().getPlugin("PDGHLoot"));
	    	        IniciarTimers();
	    	        SpawnMobs();
		      }
		    }, 100L);
	    }
	    
	    public void IniciarTimers() {
	    	getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
	    		public void run() {
	    			Alerta20Seg();
		      }
		    }, 6000L);
	    }
	  
}