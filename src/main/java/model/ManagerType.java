package model;

import jakarta.persistence.*;

@Entity
@Table(name = "manager_type")
public class ManagerType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "manager_type_id")
    private long id;

    @Column(name = "manager_type_name")
    private String typeName;

    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }

    public String getTypeName(){
        return typeName;
    }
    public void setTypeName(String typeName){
        this.typeName = typeName;
    }
}
