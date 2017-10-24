package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name = "sequenceentity")
public class SequenceEntity {

	@Id
	@TableGenerator(name = "ID_GEN", table = "sequences", pkColumnName = "seq_name", valueColumnName = "seq_number",
			pkColumnValue = "sequence", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "ID_GEN")
	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "name")
	private String name;
}
