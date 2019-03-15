package aseftian.bootfx.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.MappedSuperclass;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@MappedSuperclass
public class BaseDomain implements Serializable {
	private static final long serialVersionUID = 8458132815317089550L;
	
	private Date createdAt;
	private Date updatedAt;
	private String updatedBy;

}
