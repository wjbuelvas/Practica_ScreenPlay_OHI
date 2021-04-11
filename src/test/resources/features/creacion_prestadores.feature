#language: es

Característica: Crear prestador en OHI
  Yo como analista de negocio
  Quiero crear diferentes tipos de prestadores naturales y jurídicos
  Para asociarlos un convenio de ARL

  Antecedentes:
    Dado que Wilson desea consumir la api de OHI


  Esquema del escenario: Consultar prestadores en OHI
    Cuando   se consulta un prestador de <tipoPrestador>
    Entonces muestra la lista de prestadores existentes en OHI
    Ejemplos:
    |tipoPrestador|
    |Natural      |
    |Juridico     |


  @test
  Esquema del escenario: Crear prestadores en OHI
    Cuando se crea el nuevo prestador '<nombrePrestador>' de tipo <tipoPrestador>
    Entonces el prestador quedará guardado correctamente
    Ejemplos:
      | nombrePrestador | tipoPrestador |
      | Salud Total     | Natural       |
      | Mutual Ser      | Juridico      |

  Escenario: Crear un prestador jurídico con sede principal y varias sucursales en OHI
    Cuando  se crea el nuevo prestador 'Salud Vida' de tipo juridico
    Y se crean las sucursales del prestador
      | tipoDocumento | numeroDocumento | razonSocial    | tipoSede | nombreComercial         | codigoEspecialidad |
      | NI            | 90036312        | Sucursal Norte | Sucursal | Sucursal Valle de Lilly | 514                |
      | NI            | 90085696        | Sucursal Sur   | Sucursal | Sucursal Valle de Lili  | 521                |
    Entonces la sede principal quedará relacionada a las sedes sucursales