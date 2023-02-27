import java.io.IOException

class Entree(var ang : String,var fr : String) {
    init {
        if (ang.estVideOuBlanche() || fr.estVideOuBlanche())
            throw IOException("Les deux mots ne peuvent pas etre ni empty ni blank.")
    }

    override fun toString(): String {
        return "Ent(ang='$ang': fr='$fr')"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Entree) return false

        if (ang != other.ang) return false

        return true
    }


}

fun String.estVideOuBlanche(): Boolean {
    return this.isEmpty() || this.trim().isEmpty()
}
fun String.sigle(): String {
    var resultat=""
    for (x in this.split(" ")){
        resultat+=x[0].uppercase()
    }
    return resultat
}
