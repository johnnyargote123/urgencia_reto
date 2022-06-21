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
    var codigoAmbulancia: Int = 0
    var accidentado: Accidentado? = null
    var ocupado: Boolean = false
    var ubicacion = Ubicacion()
    //endregion

    //region Constructores
    constructor()

    constructor(
        codigoAmbulancia: Int,
        accidentado: Accidentado?,
        ocupado: Boolean,
        ubicacion: Ubicacion
    ) {
        this.codigoAmbulancia = codigoAmbulancia
        this.accidentado = accidentado
        this.ocupado = ocupado
        this.ubicacion = ubicacion
    }


    //endregion

    //region Analizadoras y modificadoras
    fun darAccidentado() = this.accidentado
    fun darOcupado() = this.ocupado

    fun darCodigo() = this.codigoAmbulancia

    fun darUbicacion() = this.ubicacion

    fun modificarAccidentado(n_accidentado: Accidentado?) {
        this.accidentado = n_accidentado
    }

    fun modificarOcupado(n_ocupado: Boolean) {
        this.ocupado = n_ocupado
    }

    fun modificarCodigo(n_codigo: Int) {
        this.codigoAmbulancia = n_codigo
    }

    fun modificarUbicacion(n_ubicacion: Ubicacion) {
        this.ubicacion = n_ubicacion
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
        tipoAccidenteDos: String, listaPacientes: TArrayList<Accidentado>?, ubicacion: Ubicacion
    ) {
        this.codigoHospital = codigoHospital
        this.nombreHospital = nombreHospital
        this.tipoAccidenteUno = tipoAccidenteUno
        this.tipoAccidenteDos = tipoAccidenteDos
        this.listaPacientes = listaPacientes!!
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

//region singeton
object SistemaUrgencias {

    //region Atibutos
    var listaHospitales = TArrayList<Hospital>()
    var listaAmbulacias = TArrayList<Ambulancia>()
    //endregion

    //region funciones propias

    fun agregarAmbulancia(codigo: Int, calle: Int, carrera: Int) {

        fun verificarAmbulancia(codigo: Int): Boolean {
            for (codigoLista in listaAmbulacias) {
                if (codigoLista.darCodigo() == codigo) return true
            }
            return false
        }

        val verificacion = verificarAmbulancia(codigo)

        if (!verificacion) listaAmbulacias.add(
            Ambulancia(
                codigo,
                null,
                false,
                Ubicacion(carrera, calle)
            )
        )

    }

    fun agregarHospital(
        codigo: Int, nombreHospital: String, calle: Int, carrera: Int,
        tipoAccidente: String, tipoAccidenteDos: String
    ) {

        fun verificarHospital(codigo: Int): Boolean {
            for (codigoLista in listaHospitales) {
                if (codigoLista.darCodigoHospital() == codigo) return true
            }
            return false
        }

        val verificacion = verificarHospital(codigo)

        if (!verificacion) listaHospitales.add(
            Hospital(
                codigo, nombreHospital, tipoAccidente, tipoAccidenteDos, null,
                Ubicacion(carrera, calle)
            )
        )

    }

    fun obtenerAmbulanciaCercana(accidentado: Accidentado): Ambulancia? {

        val ambulanciasDesocupadas = listaAmbulacias.filter { !it.darOcupado() }

        if (ambulanciasDesocupadas.size() == 0) return null
        else {
            var ambulancia = ambulanciasDesocupadas[0]
            for (p in 1 until listaAmbulacias.size) {

                if (distancia(
                        accidentado.darUbicacion(),
                        ambulanciasDesocupadas[p].darUbicacion()
                    ) <
                    distancia(accidentado.darUbicacion(), ambulancia.darUbicacion())
                ) {
                    ambulancia = ambulanciasDesocupadas[p]
                }

            }

            return ambulancia

        }


    }

    fun cambiarUbicacionAmbulancia(codigoAmbulancia: Int, ubicacion: Ubicacion) {
        val ambulancia = listaAmbulacias.find { it.codigoAmbulancia == codigoAmbulancia }

        if (ambulancia?.darOcupado() == false)
            ambulancia.modificarUbicacion(ubicacion)
    }

    fun asignarAccidentado(ambulancia: Ambulancia, accidentado: Accidentado) {

        if (!ambulancia.darOcupado()) {
            ambulancia.modificarAccidentado(accidentado)
            ambulancia.modificarOcupado(true)
        }
    }

    fun busquedaHospital(ambulancia: Ambulancia): Hospital? {
        require(ambulancia.darOcupado())

        val hospitalesConEspecialidaes = listaHospitales.filter {
            it.darTipoAccidenteUno() == ambulancia.darAccidentado()!!.darMotivo()
                    || it.darTipoAccidenteDos() == ambulancia.darAccidentado()!!.darMotivo()
        }

        if (hospitalesConEspecialidaes.size() == 0) return null
        else {
            var hospitalUno = listaHospitales[0]

            for (p in 1 until listaHospitales.size) {

                if (distancia(
                        ambulancia.darUbicacion(),
                        hospitalesConEspecialidaes[p].darUbicacion()
                    ) <
                    distancia(hospitalUno.darUbicacion(), ambulancia.darUbicacion())
                ) {
                    hospitalUno = listaHospitales[p]
                }

            }
            return hospitalUno
        }


    }


    fun registroLlegadaHospital(ambulancia: Ambulancia) {
        require(ambulancia.darOcupado())
        val hospitalCarcano = busquedaHospital(ambulancia)

        cambiarUbicacionAmbulancia(ambulancia.darCodigo(), hospitalCarcano!!.darUbicacion())
        ambulancia.modificarOcupado(false)
        hospitalCarcano.ingresarPaciente(ambulancia.darAccidentado()!!)
    }


    fun darDeAltaAccidentado(codigoHospital: Int, nombrePaciente: String) {
        val hospital = listaHospitales.find { it.codigoHospital == codigoHospital }
        hospital!!.darAltaPaciente(nombrePaciente)
    }

    //endregion

}
//endregion

//region Funciones Externas
fun distancia(ubicacion1: Ubicacion, ubicacion2: Ubicacion): Int {
    return (ubicacion2.darCalle() - ubicacion1.darCalle()) + (ubicacion2.darCarrera() - ubicacion1.darCarrera())
}
//endregion

