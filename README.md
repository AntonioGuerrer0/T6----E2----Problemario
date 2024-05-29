# Metodos_Numericos
Realizado por:
  <li>Jose Antonio Guerrero Lazcano</li>
 
<h2 align = "center"> <font color = "darkorange" size = "+6"  font face = "bauhaus 93">  Indice </font> </h2>
<header> <font color = "red" size="+1" font face = "aharoni">
                <nav class="navegacion">                   
     <li> <a href="#Descripcion"> Descripción </a> <br> </li>
                            <ul class="subindice"> 
                                <li> <a href="#Lineal"> Euler (4 ejemplos). </a> </li>
                                <li> <a href="#Cuadratica"> Runge-Kutta (4 ejemplos). </a> </li>
                                <li> <a href="#Langrage"> Taylor (4 ejemplos). </a> </li> 
                            </ul>
                    </ul>
                </nav>
            </font> </header>

<h2 align = "center"> <font font face = "forte">  <a name="Descricpcion"> Descripción </a></h2>
Los métodos de Euler, Taylor y Runge-Kutta son herramientas numéricas para resolver ecuaciones diferenciales. El método de Euler es simple pero puede ser inestable, el método de Taylor es preciso pero no se utiliza comúnmente, y el método de Runge-Kutta es preciso y estable, siendo especialmente popular el método de Runge-Kutta de orden 4.
  
Existen varios métodos para resolver ecuaciones diferenciales, cada uno con sus propias características y aplicaciones. Algunos de los más comunes son:
  <li>1.-Euler</li>
  <li>2.-Runge-Kutta</li>
  <li>3.-Taylor</li>

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

<h2 align = "center"> <font font face = "forte">  <a name="Lineal"> 1. Euler </a></h2>

<h3> <font font face = "arial"> DESCRIPCIÓN: </h3>

El método de Euler es un procedimiento numérico utilizado para aproximar soluciones de ecuaciones diferenciales ordinarias mediante la creación de una secuencia de puntos, calculados con un paso fijo, que siguen la pendiente de la función en cada punto.<h5> <font font face = "arial"> <b> <i> Ejemplo en código. </i> </b> </h5>



    
    public static void main(String[] args) {
        // Ecuación diferencial: dy/dx = (x + y + xy)
        // Condiciones iniciales: y(0) = 0.5
        double x0 = 0, y0 = 0.5, x, y, h = 0.1, xEnd = 0.3;
        int n = (int)((xEnd - x0) / h);
        
        x = x0;
        y = y0;
        
        System.out.println("x\ty");
        System.out.println(x + "\t" + y);
        
        for (int i = 0; i < n; i++) {
            y = y + h * dydx(x, y);
            x = x + h;
            System.out.println(x + "\t" + y);
        }
    }
    
    public static double dydx(double x, double y) {
        return x + y + x * y;
    }

![Captura de pantalla 2024-05-29 122105](https://github.com/AntonioGuerrer0/T6----E2----Problemario/assets/161759650/3f70e622-1d9b-45c2-bf8b-35bb29f10d23)


<h2 align = "center"> <font font face = "forte">  <a name="Cuadratica"> 2.- Runge-Kutta </a></h2>

<h3> <font font face = "arial"> DESCRIPCIÓN: </h3>

El método de Runge-Kutta es una familia de métodos numéricos para resolver ecuaciones diferenciales ordinarias (EDOs). Los métodos de Runge-Kutta son más precisos que el método de Euler. El más común es el método de Runge-Kutta de cuarto orden (RK4), que proporciona una buena combinación de precisión y eficiencia.   
<h5> <font font face = "arial"> <b> <i> Ejemplo en código. </i> </b> </h5>

   
    
    public static void main(String[] args) {
        // Ecuación diferencial: dy/dx = x^2 - y
        // Condiciones iniciales: y(0) = 2
        double x0 = 0, y0 = 2, x, y, h = 0.05, xEnd = 0.2;
        int n = (int)((xEnd - x0) / h);
        
        x = x0;
        y = y0;
        
        System.out.println("x\ty");
        System.out.println(x + "\t" + y);
        
        for (int i = 0; i < n; i++) {
            double k1 = h * dydx(x, y);
            double k2 = h * dydx(x + 0.5 * h, y + 0.5 * k1);
            double k3 = h * dydx(x + 0.5 * h, y + 0.5 * k2);
            double k4 = h * dydx(x + h, y + k3);
            
            y = y + (k1 + 2*k2 + 2*k3 + k4) / 6;
            x = x + h;
            System.out.println(x + "\t" + y);
        }
    }
    
    public static double dydx(double x, double y) {
        return x * x - y;
    }

![Captura de pantalla 2024-05-29 122118](https://github.com/AntonioGuerrer0/T6----E2----Problemario/assets/161759650/5e6a0f6a-5182-4169-9e91-ba4727b27203)

 

<h2 align = "center"> <font font face = "forte"> <a name="Langrage">  3.- Taylor </a></h2>

<h3> <font font face = "arial"> DESCRIPCIÓN: </h3>

El método de Taylor es un procedimiento numérico para resolver ecuaciones diferenciales ordinarias (EDOs) que utiliza la expansión en serie de Taylor para aproximar la solución. Este método se basa en la idea de que una función puede ser aproximada por una suma de sus derivadas evaluadas en un punto.   
<h5> <font font face = "arial"> <b> <i> Ejemplo en código. </i> </b> </h5>

     package Taylor;

public class Ejercicio_4 {
   
    public static void main(String[] args) {
        // Ecuación diferencial: dy/dx = y - x^2
        // Condiciones iniciales: y(0) = 3
        double x0 = 0, y0 = 3, x, y, h = 0.02, xEnd = 0.08;
        int n = (int)((xEnd - x0) / h);
        
        x = x0;
        y = y0;
        
        System.out.println("x\ty");
        System.out.println(x + "\t" + y);
        
        for (int i = 0; i < n; i++) {
            double k1 = h * dydx(x, y);
            double k2 = h * (dydx(x + h, y + k1));
            
            y = y + (k1 + k2) / 2;
            x = x + h;
            System.out.println(x + "\t" + y);
        }
    }
    
    public static double dydx(double x, double y) {
        return y - x * x;
    }

![Captura de pantalla 2024-05-29 122131](https://github.com/AntonioGuerrer0/T6----E2----Problemario/assets/161759650/ec6adfeb-834d-4b38-95d3-2826585b6fc5)

