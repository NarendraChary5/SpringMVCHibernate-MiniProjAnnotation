package bo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;

@NamedNativeQueries(
		{
			@NamedNativeQuery(
			name="GET_ALL_STUDENTS",
			query="SELECT SNO,SNAME,SADD FROM STUDENT ORDER BY SNO",
			resultClass=StudentBO.class)
		}
		)

@Entity
@Table(name="STUDENT")
public class StudentBO {
	@Id
	@Column(name="sno")
	private int sno;
	@Column(name="sname")
	private String name;
	@Column(name="sadd")
	private String address;
	public int getSno() {
		return sno;
	}
	public void setSno(int sno) {
		this.sno = sno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "StudentBO [sno=" + sno + ", name=" + name + ", address=" + address + "]";
	}
}