package entity;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
public class TransacaoPix {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    //private Usuario usuario;

    private String tipo;
    private BigDecimal valor;
    private Date data;

    // Outros atributos e relacionamentos, getters e setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    //public Usuario getUsuario() {
      //  return usuario;
    //}

    //public void setUsuario(Usuario usuario) {
      //  this.usuario = usuario;
    //}

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
    // Getters e setters para outros atributos e relacionamentos
}
