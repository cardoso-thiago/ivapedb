package br.com.serval.entity

import javax.persistence.*

@Entity
@Table(name = "mod_image")
data class ModImage(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var id: Long? = null,
    @Column(name = "url", unique = true)
    val url: String,
    @Column(name = "color")
    val color: String,
    @Column(name = "color_background")
    val colorBackground: String,
    @ManyToOne
    @JoinColumn(name = "mod_id")
    var mod: Mod? = null
)