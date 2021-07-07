package br.com.serval.entity

import javax.persistence.*

@Entity
@Table(name = "charging_type")
data class ChargingType(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var id: Long? = null,
    @Column(name = "description")
    var description: String,
    @OneToMany(mappedBy = "chargingType", cascade = [CascadeType.ALL], orphanRemoval = true)
    val mods: List<Mod>? = null
)