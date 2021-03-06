package listeners;

import java.util.UUID;

import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;

import entities.SimpleEntity;

public class EntityListener {

	@PrePersist
	public void prepersist(SimpleEntity simpleEntity) {
		simpleEntity.setId(UUID.randomUUID());
		System.out.println("pre persist");
	}
	
	@PreUpdate
	public void preupdate(SimpleEntity simpleEntity) {
		System.out.println("pre update");
	}
	
	@PreRemove
	public void preremove(SimpleEntity simpleEntity) {
		System.out.println("pre remove");
	}
}
