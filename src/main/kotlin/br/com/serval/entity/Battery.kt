package br.com.serval.entity

import javax.persistence.*

@Entity
@Table(name = "battery")
data class Battery(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var id: Long? = null,
    @Column(name = "description", unique = true)
    var description: String,
    @OneToMany(mappedBy = "battery", cascade = [CascadeType.ALL], orphanRemoval = true)
    val mods: List<Mod>? = null
)