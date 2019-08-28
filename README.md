# AndroidRestApiThemoviedb
Aplicacion para listar peliculas (top,popular,upcoming) utilizando el servicio de Themoviedb



La importancia de la arquitectura de software.
Algo que no puede fallar en una empresa y mucho menos en un proceso de trabajo es llevar una aplicación de código, que sea legible, bien estructurado y mantenible, que tenga la capacidad de ser adaptada a otros proyectos, capaz de crecer implementando nuevos módulos, para mi esa es la importancia de una arquitectura, en lo personal las arquitecturas no definen un proceso de trabajo pero ayudan a mantener y seguir buenas prácticas, llevar una cultura y facilitar tanto a los programadores nuevo como los de base la explicación y el entendimiento del código aplicado.


Esta aplicación fue desarrollada utilizando las bases de la arquitectura “Clean Architecture”.
El objetivo aplicado en la aplicación es el siguiente.
1. Consumiremos datos de una API y mostraremos los resultados al usuario.
2. Los resultados son una lista de películas con su nombre, imagen y contenido.

El proyecto se divide en :
Capa de presentacion
Capa de logica de negocios
Capa de datos


En la capa de presentación tenemos en el proyecto:
Todo lo contenido en el package ”UI”
Ahi encontramos 
Activity -> contiene las clases que instancia la clase activity en donde se inicializan las clases de la vista, donde se obtienen la lista de datos y se pasan a los adaptadores.
Adapter -> se encargan de de proporcionar una vista para cada item de muestros resultados, este recibe una lista de objetos de tipo “MovieUI”
Contract -> contiene todas las interface que se implementan en la vista, mantedra comunicado nuestras vistas principales con los presentadores.
viewHolder -> están contenidos en el adapter su función permite intanciar los elementos de las vistas que presentaran la información.




En el package “MP”
Encontramos los mapiadores que toman una lista de objetos que nuestro domain nos proporciona, en este package encontramos “MAPPER” donde están contenidos las clases que generar una nueva lista de objetos apta para presentar en nuestra vistas principales, los mappers son llamados en nuestros presenters para que al el resultado pueda ser inyectado en nuestro “Activity”.
En el package “MODEL” tenemos nuestros modelos con los atributos necesario para nuestras vistas.

En el package “DOMAIN”
Encontramos dos sub-package la de “MODEL” y la de use “USECASE”.
En “MODEL” encontramos modelos que son los que enviamos a nuestra capa de presentación,
Nuestro “USECASE” se encarga de solicitar la información a la capa de datos esta la recibe , la serializa y la manda a la capa de presentación un ejemplo de esto está en el archivo 
repository->mapper->MapperTopMovie.java
Esta clase recibe de entrada un objeto “TopRateMovieResponse” y como salida retorna un “TopRateMovieModel”.
Y en la capa de repositorio como comentamos es la encargada de proporcionar las funciones de serializar los datos.

En nuestra capa de “DATASOURCE”
Manejamos objetos planos que están en el package “MODEL”
En nuestro caso usamos retrofit para consumir los recursos, por esa razón en la carpeta retrofit tenemos la instancia de la librería.
En el folder datasource->cache->MovieCacheImpl manejamos la parte de las validaciones, expiración , validamos si hay datos almacenados de manera local y se lo enviamos a nuestra capa de negocio, puesto que a esa capa no le interesa de donde obtenemos los datos el solo espera que le enviemos una estructura de archivo plano en caso de haber o algun tipo de error por parte de la obtención de datos.

En este mismo package tenemos 
MovieLocalStorage -> maneja y valida el almacenamiento local
MoviesCloudDataStorage -> maneja nuestras implementaciones de retrofit.
El MovieDataFactory -> decide a cual llamar dependiendo de la lógica implementada.










En qué consiste el principio de responsabilidad única? 
Prácticamente trate de implementar esto en el código del ejercicio en lo que pude de tiempo, 
La responsabilidad única se describiría como una fábrica que al tener departamentos diferentes y que cada uno cumple una función única, sin depender y saber de otros, solo recibe un resultado y envía una respuesta según sea el caso.
En programación y en la estructuración sucede lo mismo, debe ser modular las implementaciones, cada módulo debe realizar específicamente un propósito sin conocer  su capa externa.
Esto se puede decir que cada módulo o capa tiene una tarea única y esa es su única responsabilidad. 


Cuál es su propósito?
Permite entender el código de manera más dinámica, la implementación de nuevas características es más fácil puesto que solo debemos agregar esas características en esa capa o departamento si lo vemos en una fábrica, si un error ocurre sabremos qué capa es la errónea sin afectar los demás.










