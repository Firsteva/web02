/* Value Object
 * => Class 문법을 사용하여 사용자 정의 데이터 타입 만들기
 * 
 * 1) Serializable 인터페이스 구현
 *    => SerialVersionUID 스태틱 변수 선언
 * 
 * 2) 인스턴스 변수 선언
 * 
 * 3) setter/getter 생성
 * 
 * 4) 기본 생성자와 파라미터 값을 받는 생성자 선언
 * 
 * 5) equals()/hashCode() 메서드 오버라이딩
 * 
 * 6) toString() 오버라이딩
 */
package java63.servlets.test.domain;

import java.io.Serializable;

public class Member implements Serializable, Cloneable {

	private static final long serialVersionUID = 1L;
  
  protected String    id;
  protected String    pwd;
  protected String    mail;
  protected String    name;
  protected String    tel;
  protected String    fax;
  protected String    adr;
  protected String    pht;
  protected String    ano;
  
  public Member(){}

  public Member(String id, String pwd, String mail, String name, String tel,
			String fax, String adr, String pht, String ano) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.mail = mail;
		this.name = name;
		this.tel = tel;
		this.fax = fax;
		this.adr = adr;
		this.pht = pht;
		this.ano = ano;
	}

	@Override
  public Member clone() throws CloneNotSupportedException {
    return (Member) super.clone();
  }
  
  @Override
  public String toString() {
    return "Member [id="+id+", pwd="+pwd+", mail="+mail+", name="+name+
    		", tel="+tel+", fax="+fax+", adr="+adr+", pht="+pht+", ano="+ano+"]";
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    result = prime * result + ((pwd == null) ? 0 : pwd.hashCode());
    result = prime * result + ((mail == null) ? 0 : mail.hashCode());
    result = prime * result + ((name == null) ? 0 : name.hashCode());
    result = prime * result + ((tel == null) ? 0 : tel.hashCode());
    result = prime * result + ((fax == null) ? 0 : fax.hashCode());
    result = prime * result + ((adr == null) ? 0 : adr.hashCode());
    result = prime * result + ((pht == null) ? 0 : pht.hashCode());
    result = prime * result + ((ano == null) ? 0 : ano.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Member other = (Member) obj;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    if (pwd == null) {
      if (other.pwd != null)
        return false;
    } else if (!pwd.equals(other.pwd))
      return false;
    if (mail == null) {
      if (other.mail != null)
        return false;
    } else if (!mail.equals(other.mail))
      return false;
    if (name == null) {
      if (other.name != null)
        return false;
    } else if (!name.equals(other.name))
      return false;
    if (tel == null) {
      if (other.tel != null)
        return false;
    } else if (!tel.equals(other.tel))
      return false;
    if (fax == null) {
      if (other.fax != null)
        return false;
    } else if (!fax.equals(other.fax))
      return false;
    if (adr == null) {
      if (other.adr != null)
        return false;
    } else if (!adr.equals(other.adr))
      return false;
    if (pht == null) {
      if (other.pht != null)
        return false;
    } else if (!pht.equals(other.pht))
      return false;
    if (ano == null) {
      if (other.ano != null)
        return false;
    } else if (!ano.equals(other.ano))
      return false;
    return true;
  }
  
  public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getAdr() {
		return adr;
	}

	public void setAdr(String adr) {
		this.adr = adr;
	}

	public String getPht() {
		return pht;
	}

	public void setPht(String pht) {
		this.pht = pht;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}
}  