package project.end.mas.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@NoArgsConstructor
@DynamicUpdate
@Getter
@Setter
@Entity
public class Person {

    public Person(@NotNull String firstName, @NotNull String lastName, @NotNull String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_person")
    private long id;

    @NotNull
    @Column(name = "first_name")
    private String firstName;

    @NotNull
    @Column(name = "last_name")
    private String lastName;

    @NotNull
    @Column(name = "phone_number")
    private String phoneNumber;

    //1-0..1
    @OneToOne
    @JoinColumn(name = "id_rider")
    private Rider rider;

    //1-0..1
    @OneToOne
    @JoinColumn(name = "id_owner")
    private Owner owner;

    @Transient
    public String getPersonData() {
        return getFirstName() + " " + getLastName();
    }
}