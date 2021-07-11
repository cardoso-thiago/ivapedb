package br.com.serval.entity

import javax.persistence.*

@Entity
@Table(name = "mod")
data class Mod(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var id: Long? = null,
    @Column(name = "name", unique = true)
    val name: String,
    @Column(name = "dimensions")
    val dimensions: String,
    @Column(name = "weight")
    val weight: String,
    @Column(name = "capacity")
    val capacity: String,
    @Column(name = "output_wattage")
    val outputWattage: String,
    @Column(name = "display")
    val display: String,
    @ManyToOne
    @JoinColumn(name = "brand_id")
    var brand: Brand? = null,
    @ManyToOne
    @JoinColumn(name = "battery_id")
    var battery: Battery? = null,
    @ManyToOne
    @JoinColumn(name = "charging_type_id")
    var chargingType: ChargingType? = null,
    @OneToMany(mappedBy = "mod", cascade = [CascadeType.ALL], orphanRemoval = true)
    var modImages: List<ModImage>? = null
)