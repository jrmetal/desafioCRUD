package domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@SuppressWarnings("serial")
public class Usuario extends GenericDomain {

	// classe de entidade onde s�o declarados os m�todos e atributos da entidade
	// � uma extens�o da classe GenericDomain onde � gerado os ID

	@Column(length = 40, nullable = false)
	private String usuario;

	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataNascimento;

	@Column(length = 40, nullable = true)
	private String rg;

	@Column(length = 40, nullable = false)
	private String endereco;

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	@Override
	public String toString() {
		return "Usuario [usuario=" + usuario + ", dataNascimento=" + dataNascimento + ", rg=" + rg + ", endereco="
				+ endereco + "]";
	}
}
