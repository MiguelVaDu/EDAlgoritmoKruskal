# EDAlgoritmoKruskal
Proyecto de Estructura de Datos sobre Algoritmo Kruskal elaborado por el grupo 01 curso ED G1

1.	INTRODUCCIÓN
Somos una empresa de internet que nuestro servicio debe brindar los servicios de internet más excepcionales sin la necesidad de instalaciones complicadas o costosas, ya sea en el mismo hogar, en una oficina o en algún otro espacio público, nos enorgullece proporcionar soluciones de conectividad inalámbrica que se adaptan a las necesidades individuales de nuestros clientes.
2.	MARCO TEÓRICO
2.1.	TEORÍA DE GRAFOS
Según Godsil y Royle (2001), la teoría de grafos estudia las propiedades de los grafos. Formalmente, un grafo (G) está constituido por dos conjuntos disjuntos, uno llamado vértices o nodos (V) y otro llamado aristas (A), la cual poseen una relación que asocia un par de nodos a través de una arista.
 
Fuente: https://slideplayer.es/slide/11607730/
Esta teoría posee diversas aplicaciones como en las Ciencias Biológicas, Ciencias Computacionales, Ciencias económicas, Ingenierías, etc. Además, la teoría de grafos ayuda a los estudiantes a potencias sus habilidades necesarias para modelar las estructuras y procesos para dar una solución computacional a los diversos problemas que se puedan presentar.
2.2.	TIPOS DE GRAFOS
2.2.1.	GRAFO CONEXO
Wasserman y Faust (2013), señalan que un grafo conexo es denominado así, si es que existe al menos un camino que conecte a cada par de vértices.
 
Fuente: chrome-extension://efaidnbmnnnibpcajpcglclefindmkaj/https://www.unipamplona.edu.co/unipamplona/portalIG/home_23/recursos/general/11072012/grafo3.pdf
2.2.2.	GRAFO DIRIGIDO
Bang-Jensen y Gutin (2000), señalan que se le denomina grafo dirigido, si es que las aristas tienen un sentido definido, ósea si es que tienen una orientación. A este tipo de grafos también se les denomina dígrafos.
 
Fuente: https://www.researchgate.net/figure/Ejemplos-de-un-grafo-dirigido-y-un-grafo-no-dirigido_fig7_309278789
2.2.3.	GRAFO PONDERADO
Se caracterizan por el valor asociado que tiene cada arista. Este valor puede representar el costo, peso o longitud de cada arista. (Wasserman y Faust, 2013).
 
Fuente: https://www.wikiwand.com/es/Anexo:Ejemplo_de_Algoritmo_de_Dijkstra
 
2.2.4.	GRAFO CÍCLICO
Un grafo es cíclico, si es que tiene al menos un ciclo, ósea un camino simple cerrado. (Weisstein, s.f.).
 
Fuente: https://platzi.com/clases/2156-estructuras-datos/33741-graphs/
2.3.	ÁRBOL
Este es un grafo acíclico y conexo, donde la cantidad de aristas sería n-1 si consideramos a la cantidad de vértices como n. Estos árboles conectan todos los vértices usando la menor cantidad de aristas posible (Wasserman y Faust, 2013).
 ´
Fuente: Elaboración Propia.

 
2.4.	ESTRUCTURAS MATRICIALES
2.4.1.	MATRIZ DE INCIDENCIA
Es una matriz binaria, cuya función es representar el cómo se relacionan los diversos nodos del grafo. En la matriz, las filas representan a los nodos y las columnas, a las aristas. Respecto a la condición que se debe cumplir, esta cambia dependiendo del tipo de grafo.
Si el grafo es no dirigido, la condición que se debe cumplir es que, por cada nodo unido por una arista, se coloca el valor de 1 y al resto se le coloca 0.
 
Fuente: Elaboración Propia.

En caso sea un grafo dirigido, si el nodo es la salida de la arista se coloca 1, si no es adyacente de la arista se coloca 0 y si es entrada de la arista se coloca -1.

 
Fuente: Elaboración Propia.

2.4.2.	MATRIZ DE ADYACENCIA
Es una matriz cuadrada que se utiliza para representar las diversas relaciones entre todos los nodos, dicha matriz comienza con 0 en todas sus posiciones, siendo los nodos representados en las columnas y filas. Respecto a la condición que se debe cumplir, esta también cambia dependiendo del tipo de grafo. 
Si es un grafo no dirigido, por cada arista que une a dos nodos, se le debe sumar el valor de uno al valor que hay actualmente en la ubicación de la matriz. 

 
Fuente: Elaboración Propia.

Si el grafo es ponderado, en lugar de colocar 1 se le debe sumar el valor del peso de la respectiva arista.
 
Fuente: Elaboración Propia.

 En caso sea un grafo dirigido, si el vértice i está conectado al vértice j mediante una arista dirigida, se debe colocar un 1 en la posición (i, j), caso contrario se coloca un 0.
 
Fuente: Elaboración Propia.

 
2.5.	ALGORITMO DE KRUSKAL
Este es un algoritmo de teoría de grafos utilizado para encontrar el árbol de expansión mínima de un grafo ponderado no dirigido. Según Joyanes y Zahonero (2004) El algoritmo de Kruskal es un método cuya función es encontrar el árbol de expansión mínima en un grafo no dirigido ponderado. Consiste en ordenar las aristas del grafo de menor a mayor según sus pesos y luego seleccionar las aristas en orden ascendente, siempre y cuando no formen un ciclo en el árbol parcial construido. Este proceso se repite hasta que todas las aristas estén incluidas en el árbol de expansión mínima. El algoritmo utiliza una estructura de datos llamada "conjunto disjunto" para determinar si una arista forma un ciclo o no. El árbol resultante es el subgrafo que contiene todos los vértices del grafo original, con la menor suma de pesos posibles.
Para entender mejor esta definición, se ha desarrollado el siguiente ejemplo:
 
Fuente: https://www.youtube.com/watch?v=RSE5EYTUK1g
Teniendo el grafo presente, lo que se tiene que hacer es buscar la arista de menor pesado, al ver que son 2, la selección se hace de forma arbitraria.

 
Fuente: https://www.youtube.com/watch?v=RSE5EYTUK1g
Ahora, se selecciona la siguiente arista de menor peso.
 
Fuente: https://www.youtube.com/watch?v=RSE5EYTUK1g
Se debe repetir el proceso, seleccionando a aquellas aristas que no generen ciclos.
 
Fuente: https://www.youtube.com/watch?v=RSE5EYTUK1g
Al ver este grafo, vemos que hay 3 posibilidades de elección, sin embargo la arista que une a los nodos 4 y 6 se descarta, ya que si se elige dicha arista, se estaría generando un ciclo.
 
Se elige cualquiera de las otras 2 opciones y vemos que ya no se podría escoger alguna arista, ya que con cualquier elección, se generaría un ciclo.
Fuente: https://www.youtube.com/watch?v=RSE5EYTUK1g




3.	PROBLEMATICA
La empresa enfrenta un gran desafio en su objetivo de conectar todas las casas, ya que requiere encontrar soluciones que minimicen los costos asociados. La principal problemática radica en la necesidad de utilizar la menor cantidad de cable posible, lo que implica optimizar y planificar cuidadosamente las conexiones. Conectar todas las casas de manera eficiente es esencial para brindar un servicio de calidad a los clientes, y lograrlo con la menor cantidad de cable posible implica una planificacion minuciosa y un uso inteligente de los recursos disponibles.

4.	SOLUCION
Para poder solucionarlo se utilizará el algoritmo de Kruskal para encontrar un árbol de expansión mínima. En este contexto, el grafo representaría las casas y las aristas representan las conexiones entre ellas. Primero vamos a representar el conjunto de casas como un grafo ponderado, donde cada casa es un nodo y el peso de cada arista representa la distancia o costo de la conexión entre las casas. Después ordenar de manera no decreciente las aristas de acuerdo con sus pesos, inicializamos un grafo vacío como el árbol de expansión mínima, recorrer las aristas en orden ascendente de acuerdo con sus pesos. Para cada arista, verificar si agregarla al árbol de expansión mínima forma un ciclo. Si no forma un ciclo, agregar la arista al árbol de expansión mínima y así seguir hasta que todas estén conectadas. Al finalizar, se mostraría la manera más eficiente de conectar todas las casas utilizando la menor cantidad de cable posible y así poder minimizar los costos.
5.	CÓDIGO
5.1.	DICCIONARIO DE CLASES
5.1.1.	NODO
Esta clase hace uso de la interfaz “Serializable” y tiene los siguiente atributos y métodos.
ATRIBUTOS
•	nombre: Este atributo, de tipo “String”, representa el nombre del nodo
•	id: Este atributo, de tipo “int”, representa el valor del identificador del Nodo.
•	coordenada_X: Este atributo, de tipo “int”, representa el valor en el eje x del plano de la ciudad.
•	coordenada_Y: Este atributo, de tipo “int”, representa el valor en el eje y del plano de la ciudad.

METODOS
•	getNombre(): Este método retorna el atributo “nombre”.
•	getId(): Este método retorna el atributo “id”.
•	getCoordenada_X(): Este método retorna el atributo “coordenada_X”.
•	getCoordenada_Y(): Este método retorna el atributo “coordenada_Y”.
•	setNombre(String nombre): Este método destina el valor del argumento, al atributo “nombre”.
•	setId(int id): Este método destina el valor del argumento, al atributo “id”.
•	setCoordenada_x(int coordenada_X): Este método destina el valor del argumento, al atributo “coordenada_X”.
•	setCoordenada_y(int coordenada_Y): Este método destina el valor del argumento, al atributo “coordenada_Y”.

5.1.2.	ARISTA
Esta clase hace uso de genéricos (<T>), también hace uso de la interfaz “Serializable” y tiene los siguiente atributos y métodos.
ATRIBUTOS
•	origen: Este atributo, sin un tipo de especificación de objetos, representa el origen de la conexión de la arista, para el caso práctico que se está desarrollando, vendría a ser un nodo.
•	destino: Este atributo, sin un tipo de especificación de objetos, representa el destino de la conexión de la arista, para el caso práctico que se está desarrollando, vendría a ser un nodo.
•	peso: Este atributo, de tipo “int”, representa el peso o valor de la arista.

METODOS
		getOrigen(): Este método retorna el atributo “origen”.
•	getDestino(): Este método retorna el atributo “destino”.
•	getPeso():  Este método retorna el atributo “peso”.
•	setPeso(int peso): Este método destina el valor del argumento, al atributo “peso”.

 
5.1.3.	GRAFO
Esta clase hace uso de genéricos que se extiende de la clase “Nodo” (<T extends Nodo>), también hace uso de la interfaz “Serializable” y tiene los siguiente atributos y métodos.
ATRIBUTOS
•	nodos: Este atributo de tipo “List<T>”, representa a una lista de objetos sin un tipo de especificación, para el caso del ejemplo práctico, representa los nodos en el grafo.
•	aristas: Este atributo de tipo “List<Arista <T>>”, representa la lista de aristas del grafo.
•	grafo: Este atributo de tipo “Map<T, List<Arista<T>>>”, representa el grafo con nodos y sus aristas.

METODOS
•	agregarNodo(T nodo): Este método agrega un nodo al grafo.
•	agregarNodoAlGrafo( T nodo): Este método retornar un false si el nodo está vacio o un true en el caso se haya agregado el nodo correctamente.
•	agregarArista(T origen, T destino, int peso): Este método agrega una arista entre dos nodos, y su peso.
•	obtenerCaminoMasCorto(T inicio, T fin): Este método retorna una lista genérica con el camino más corto.
•	getNodos(): Este método retorna el atributo “nodos”.
•	getAristas(): Este método retorna el atributo “aristas”.
•	getGrafo(): Este método retorna el atributo “grafo”.
•	obtenerMatrizDeAdyacencia(): Este método retorna la matriz de adyacencia del grafo.
•	eliminarNodoYAdyacentes(T nodo): Este método elimina al nodo pasado en el argumento con sus respectivas aristas. 
•	eliminarArista(T inicio, T llegada): Este método la arista unida a los nodos pasados en el argumento.
•	sonAdyacentes(Nodo nodo1, Nodo nodo2): Este método retorna “true” si los nodos son adyacentes, caso contrario retorna “false”.
•	hallarMatrizDeAdyecencia(): Este método retorna la matriz “MatrizDeAdyecencia”.







5.1.4.	KRUSKAL
Esta clase es una clase hija de la clase Usuario.
ATRIBUTOS
•	grafo: Este es un  atributo de tipo “Grafo<T>”
•	ArbolExpansionMinimo: Este es un  atributo de tipo “List<Arista<T>>”

METODOS
•	obtenerArbolExpansionMinima(): Este método retorna el atributo aem, que es el arbol de expansión mínima.
•	hayCamino(): Este método retorna un booleano, del método dfs.
•	dfs(): Este método recorre el grafo de expansión mínima.

5.1.5.	USUARIO
Esta clase implementa la interfaz “Serializable” y tiene los siguiente atributos y métodos.

ATRIBUTOS
•	correo: Este atributo de tipo “String”, representa a una cadena que es el correo del Usuario.
•	contrasena: Este atributo de tipo “String”, representa a una cadena que es la contraseña del Usuario.s
METODOS

•	getCorreo(): Este método retorna el atributo “correo”.
•	setCorreo(String correo): Este método destina el valor del argumento, al atributo “correo”.
•	getContrasena(): Este método retorna el atributo “contrasena”.
•	setContrasena(String contrasena): Este método destina el valor del argumento, al atributo “contrasena”.

5.1.6.	CLIENTE
Esta clase es una clase hija de la clase Usuario.

ATRIBUTOS
•	nombreComp: Este atributo de tipo “String”, representa a una cadena que es el nombre completo del cliente.
•	dni: Este atributo de tipo “String”, representa a una cadena que es el DNI del cliente.
•	telefono: Este atributo de tipo “String”, representa a una cadena que es el  del cliente.
•	n: Este atributo de tipo “Nodo”, representa al cliente como Nodo en el grafo.
METODOS
•	getNombreComp(): Este método retorna el atributo “nombreComp”.
•	setNombreComp(String nombreComp): Este método destina el valor del argumento, al atributo “nombreComp”.
•	getDni(): Este método retorna el atributo “dni”.
•	setDni(String dni): Este método destina el valor del argumento, al atributo “dni”.
•	getTelefono() : Este método retorna el atributo “telefono”.
•	getN(): Este método retorna el atributo “n”.
•	setTelefono(String telefono): Este método destina el valor del argumento, al atributo “telefono”.
•	setN(Nodo n): Este método destina el valor del argumento, al atributo “n”.
5.1.7.	ADMINISTRADOR
Esta clase es una clase hija de la clase Usuario.
ATRIBUTOS
•	Solicitudes: Este atributo de tipo “List<Solicitud>”

METODOS
•	getSolicitud(): Este método retorna el atributo “solicitud”.
•	setSolicitud(List<Solicitud> solicitudes):
5.1.8.	SOLICITUD

ATRIBUTOS
•	Descripción : Este atributo de tipo “String”, representa a una cadena que la descriçión.
•	ID : Este atributo, de tipo “int”, representa el valor del identificador.
METODOS
•	getDescripcion(): Este método retorna el atributo “descripcion”.
•	getId(): Este método retorna el atributo “id”.
•	setDescripcion(String Descripcion): Este método destina el valor del argumento, al atributo “Descripcion”.
•	setId(int Id): Este método destina el valor del argumento, al atributo “id”.
 
