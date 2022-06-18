package mundo

import ean.collections.TArrayList

//region Objetos
class Ubicacion : Comparable<Ubicacion> {

    //region Atributos
    var carrera: Int = 0
    var calle: Int = 0
    //endregion

    //region Constructores
    constructor()

    constructor(carrera: Int, calle: Int) {
        this.carrera = carrera
        this.calle = calle
    }
    //endregion

    //region Analizadoras y modificadoras
    fun darCarrera() = this.carrera
    fun darCalle() = this.calle
    fun modificarCarrera(n_carrera: Int) {
        this.carrera = n_carrera
    }

    fun modificarCalle(n_calle: Int) {
        this.calle = n_calle
    }
    //endregion

    //region Sobrecargas
    override fun compareTo(other: Ubicacion): Int {
        return if (this.darCalle() > other.darCalle()) {
            1
        } else if (other.darCalle() > this.darCalle()) {
            -2
        } else {
            if (this.darCarrera() > other.darCarrera()) {
                1
            } else if (other.darCarrera() > this.darCarrera()) {
                -1
            } else 0
        }
    }
    //endregion

}

class Accidentado : Comparable<Accidentado> {

    //region Atributos
    var nombreAccidentado: String = ""
    var ubicacion = Ubicacion()
    var motivo: String = ""
    //endregion

    //region Constructores
    constructor()

    constructor(nombreAccidentado: String, ubicacion: Ubicacion, motivo: String) {
        this.nombreAccidentado = nombreAccidentado
        this.ubicacion = ubicacion
        this.motivo = motivo
    }
    //endregion

    //region Analizadoras y modificadoras
    fun darNombre() = this.nombreAccidentado
    fun darUbicacion() = this.ubicacion
    fun darMotivo() = this.motivo
    fun modificarNombre(n_nombre: String) {
        this.nombreAccidentado = n_nombre
    }

    fun modificarUbicacion(n_ubicacion: Ubicacion) {
        this.ubicacion = n_ubicacion
    }

    fun modificarMotivo(n_motivo: String) {
        this.motivo = n_motivo
    }
    //endregion

    //region Sobrecargas
    override fun compareTo(other: Accidentado): Int {
        return if (other.darNombre() != this.darNombre())
            1
        else -1
    }
    //endregion

}

class Ambulancia {

    //region Atributos
    var accidentado: Accidentado? = null
    var ocupado: Boolean = false
    //endregion

    //region Analizadoras y modificadoras
    fun darAccidentado() = this.accidentado
    fun darOcupado() = this.ocupado

    fun modificarAccidentado(n_accidentado: Accidentado?) {
        this.accidentado = n_accidentado
    }

    fun modificarOcupado(n_ocupado: Boolean) {
        this.ocupado = n_ocupado
    }
    //endregion

    //region Funciones Internas
    fun ingresarAccidentado(nuevo_accidentado: Accidentado) {
        require(!darOcupado())
        modificarAccidentado(nuevo_accidentado)
        modificarOcupado(true)
    }

    fun desocuparAmbulancia() {
        require(this.darOcupado())
        modificarOcupado(false)
        modificarAccidentado(null)

    }

    fun cambiarUbicacion(nueva_ubicacion: Ubicacion) {
        darAccidentado()?.modificarUbicacion(nueva_ubicacion)
    }
    //endregion

}

class Hospital : Comparable<Hospital> {

    //region Atributos
    var codigoHospital: Int = 0
    var nombreHospital: String = ""
    var tipoAccidenteUno: String = ""
    var tipoAccidenteDos: String = ""
    var listaPacientes = TArrayList<Accidentado>()
    var ubicacion = Ubicacion()
    //endregion

    //region Constructores
    constructor()

    constructor(
        codigoHospital: Int, nombreHospital: String, tipoAccidenteUno: String,
        tipoAccidenteDos: String, listaPacientes: TArrayList<Accidentado>, ubicacion: Ubicacion
    ) {
        this.codigoHospital = codigoHospital
        this.nombreHospital = nombreHospital
        this.tipoAccidenteUno = tipoAccidenteUno
        this.tipoAccidenteDos = tipoAccidenteDos
        this.listaPacientes = listaPacientes
        this.ubicacion = ubicacion
    }
    //endregion

    //region Modificadoras y analizadoras
    fun darCodigoHospital() = this.codigoHospital
    fun darNombreHospital() = this.nombreHospital
    fun darTipoAccidenteUno() = this.tipoAccidenteUno
    fun darTipoAccidenteDos() = this.tipoAccidenteDos
    fun darPacientes() = this.listaPacientes
    fun darUbicacion() = this.ubicacion

    fun modificarCodigoHospital(n_codigoHospital: Int) {
        this.codigoHospital = n_codigoHospital
    }

    fun modificarNombreHospital(n_nombreHospital: String) {
        this.nombreHospital = n_nombreHospital
    }

    fun modificarTipoAccidenteUno(n_tipoAccidente: String) {
        this.tipoAccidenteUno = n_tipoAccidente
    }

    fun modificarTipoAccidenteDos(n_tipoAccidente: String) {
        this.tipoAccidenteDos = n_tipoAccidente
    }

    fun modificarPacientes(n_pacientes: TArrayList<Accidentado>) {
        this.listaPacientes = n_pacientes
    }

    fun modificarUbicacion(n_ubicacion: Ubicacion) {
        this.ubicacion = n_ubicacion
    }
    //endregion

    //region Sobrecarga
    override fun compareTo(other: Hospital): Int {
        return if (other.codigoHospital != this.codigoHospital) 1
        else -1
    }
    //endregion

    //region funciones Propias
    fun buscarPaciente(nombre: String): Boolean {
        val accidentado = listaPacientes.find { it.darNombre() == nombre }
        return accidentado != null
    }

    fun buscarAccidente(accidente: String): Boolean {
        return accidente == this.tipoAccidenteUno || accidente == this.tipoAccidenteDos
    }

    fun ingresarPaciente(paciente: Accidentado) {
        val accidentado = listaPacientes.find { it.darNombre() == paciente.darNombre() }

        if (accidentado == null && buscarAccidente(paciente.darMotivo()))
            listaPacientes.add(paciente)
    }


    fun darAltaPaciente(paciente: String) {
        val accidentado = listaPacientes.find { it.darNombre() == paciente }
        val posicionLista = listaPacientes.indexOf(accidentado)

        if (accidentado != null)
            listaPacientes.remove(posicionLista)
    }

    //endregion

}

//endregion

//region Funciones Externas
fun distancia(ubicacion1: Ubicacion, ubicacion2: Ubicacion): Int {
    return (ubicacion2.darCalle() - ubicacion1.darCalle()) + (ubicacion2.darCarrera() - ubicacion1.darCarrera())
}
//endregion

