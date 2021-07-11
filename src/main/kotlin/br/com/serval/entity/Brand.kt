package br.com.serval.entity

import javax.persistence.*

@Entity
@Table(name = "brand")
data class Brand(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var id: Long? = null,
    @Column(name = "name", unique = true)
    var name: String,
    @Column(name = "website")
    var website: String,
    @OneToMany(mappedBy = "brand", cascade = [CascadeType.ALL], orphanRemoval = true)
    val mods: List<Mod>? = null
)