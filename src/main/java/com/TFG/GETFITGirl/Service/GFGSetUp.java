package com.TFG.GETFITGirl.Service;

import com.TFG.GETFITGirl.Dto.Comidas.ComidaEntity;
import com.TFG.GETFITGirl.Dto.Ejercicio.EjercicioEntity;
import com.TFG.GETFITGirl.Dto.Usuario.UsuarioEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class GFGSetUp implements ApplicationRunner {

    @Autowired
    private GFGService GFGServiceImpl;

    /**
     * Método que se ejecutará al iniciar la aplicación.
     * Este método sirve como modo de introducción de entities en la base de datos
     * de la aplicación. Así, cuando ejecutemos la aplicación se añadirán a la
     * base de datos de la aplicación nuevos usuarios, ejercicios y comidas.
     * Esto solo pasará la 1ª vez que arranquemos la aplicación.
     * @param args
     * @throws Exception
     */
    @Override
    public void run(ApplicationArguments args) throws Exception {
        if (GFGServiceImpl.listadoUsuarios().size() == 0) {
            GFGServiceImpl.añadirUsuario(new UsuarioEntity(
                    0,
                    0,
                    "David",
                    "Lima",
                    "Rodriguez",
                    "DavidTrainer@Gmail.com",
                    "1992-10-15",
                    180,
                    80,
                    "ES521234567890",
                    "1234"));

            GFGServiceImpl.añadirUsuario(new UsuarioEntity(
                    0,
                    1,
                    "Carlota",
                    "Martínez",
                    "Peñas",
                    "CarlotaMP@Gmail.com",
                    "1991-09-21",
                    171,
                    70,
                    "ES520987654321",
                    "1234"));

            GFGServiceImpl.añadirUsuario(new UsuarioEntity(
                    0,
                    1,
                    "María",
                    "Castaño",
                    "Pérez",
                    "MariaCP@Gmail.com",
                    "2001-06-01",
                    170,
                    60,
                    "ES520987654322",
                    "1234"));

            GFGServiceImpl.añadirUsuario(new UsuarioEntity(
                    0,
                    1,
                    "Sara",
                    "Orduna",
                    "Castillo",
                    "SaraOrCas@Gmail.com",
                    "1998-03-04",
                    158,
                    58,
                    "ES520987654337",
                    "1234"));

            GFGServiceImpl.añadirUsuario(new UsuarioEntity(
                    0,
                    1,
                    "Maite",
                    "Lozano",
                    "Morillas",
                    "Maite_LM@Gmail.com",
                    "2000-08-11",
                    165,
                    67,
                    "ES520987658740",
                    "1234"));
        }


        // ::::: INTRODUCCIÓN DE EJERCICIOS EN LA BASE DE DATOS ::::: //

        if (GFGServiceImpl.listadoEjercicios().size() == 0) {
            GFGServiceImpl.añadirEjercicio(new EjercicioEntity(
                    0,
                    "Press banca",
                    "Pectorales",
                    "https://youtu.be/eqLT5AE9YCU"));
            GFGServiceImpl.añadirEjercicio(new EjercicioEntity(
                    0,
                    "Lagartijas",
                    "Pectorales",
                    "https://youtu.be/PYLecpZJGpE"));
            GFGServiceImpl.añadirEjercicio(new EjercicioEntity(
                    0,
                    "Fondos",
                    "Pectorales",
                    "https://youtu.be/_NgpDQ1ojys"));
            GFGServiceImpl.añadirEjercicio(new EjercicioEntity(
                    0,
                    "Press inclinado",
                    "Pectorales",
                    "https://youtu.be/-VtOLVAfoIU"));
            GFGServiceImpl.añadirEjercicio(new EjercicioEntity(
                    0,
                    "Press con mancuerna",
                    "Pectorales",
                    "https://youtu.be/2AcLs-Tr85M"));
            GFGServiceImpl.añadirEjercicio(new EjercicioEntity(
                    0,
                    "Cruce de poleas",
                    "Pectorales",
                    "https://youtu.be/XnaMi2Gb_9Q"));
            GFGServiceImpl.añadirEjercicio(new EjercicioEntity(
                    0,
                    "Dominadas",
                    "Espalda",
                    "https://youtu.be/ouvnonII-Ws"));
            GFGServiceImpl.añadirEjercicio(new EjercicioEntity(
                    0,
                    "Jalones al pecho",
                    "Espalda",
                    "https://youtu.be/DzvOf1fqGDA"));
            GFGServiceImpl.añadirEjercicio(new EjercicioEntity(
                    0,
                    "Remo con barra",
                    "Espalda",
                    "https://youtu.be/3uiWjik2yEQ"));
            GFGServiceImpl.añadirEjercicio(new EjercicioEntity(
                    0,
                    "Remo invertido",
                    "Espalda",
                    "https://youtu.be/7Qf8GOf--a0"));
            GFGServiceImpl.añadirEjercicio(new EjercicioEntity(
                    0,
                    "Peso muerto",
                    "Espalda",
                    "https://youtu.be/_LJUalLAQ_4"));
            GFGServiceImpl.añadirEjercicio(new EjercicioEntity(
                    0,
                    "Encogiminetos con barra",
                    "Espalda",
                    "https://youtu.be/TKrEp0jgeFE"));
            GFGServiceImpl.añadirEjercicio(new EjercicioEntity(
                    0,
                    "Sentadilla con barra",
                    "Cuádriceps",
                    "https://youtu.be/SNW8HAlM2Iw"));
            GFGServiceImpl.añadirEjercicio(new EjercicioEntity(
                    0,
                    "Sentadilla frontal",
                    "Cuádriceps",
                    "https://youtu.be/GCMPzpCqPoo"));
            GFGServiceImpl.añadirEjercicio(new EjercicioEntity(
                    0,
                    "Leg press",
                    "Cuádriceps",
                    "https://youtu.be/aXokNaCJB18"));
            GFGServiceImpl.añadirEjercicio(new EjercicioEntity(
                    0,
                    "Desplantes",
                    "Cuádriceps",
                    "https://youtu.be/NurJKlGfVzE"));
            GFGServiceImpl.añadirEjercicio(new EjercicioEntity(
                    0,
                    "Sentadilla búlgara",
                    "Cuádriceps",
                    "https://youtu.be/K-6DG1hcHzU"));
            GFGServiceImpl.añadirEjercicio(new EjercicioEntity(
                    0,
                    "Extensiones",
                    "Cuádriceps",
                    "https://youtu.be/HXqas5IpC8k"));
            GFGServiceImpl.añadirEjercicio(new EjercicioEntity(
                    0,
                    "Hip thrust",
                    "Glúteos",
                    "https://youtu.be/2LKqiecERXw"));
            GFGServiceImpl.añadirEjercicio(new EjercicioEntity(
                    0,
                    "Pull through",
                    "Glúteos",
                    "https://youtu.be/OkcryKUZTZs"));
            GFGServiceImpl.añadirEjercicio(new EjercicioEntity(
                    0,
                    "Frog pumps",
                    "Glúteos",
                    "https://youtu.be/KvdJEqifOLk"));
            GFGServiceImpl.añadirEjercicio(new EjercicioEntity(
                    0,
                    "Hiperextensiones",
                    "Glúteos",
                    "https://youtu.be/PicwGUbAjb4"));
            GFGServiceImpl.añadirEjercicio(new EjercicioEntity(
                    0,
                    "Patada de glúteo",
                    "Glúteos",
                    "https://youtu.be/es1GiFH2qYw"));
            GFGServiceImpl.añadirEjercicio(new EjercicioEntity(
                    0,
                    "Peso muerto rumano",
                    "Femorales",
                    "https://youtu.be/NIng2JWF1Rs"));
            GFGServiceImpl.añadirEjercicio(new EjercicioEntity(
                    0,
                    "Curl en máquina",
                    "Femorales",
                    "https://youtu.be/pffYI5NpYo8"));
            GFGServiceImpl.añadirEjercicio(new EjercicioEntity(
                    0,
                    "Curl sentado",
                    "Femorales",
                    "https://youtu.be/26-ULvk4bjU"));
            GFGServiceImpl.añadirEjercicio(new EjercicioEntity(
                    0,
                    "Slide curl",
                    "Femorales",
                    "https://youtu.be/kkkTfzi2gj4"));
            GFGServiceImpl.añadirEjercicio(new EjercicioEntity(
                    0,
                    "Curl nórdico",
                    "Femorales",
                    "https://youtu.be/U7zU0eHQRaw"));
            GFGServiceImpl.añadirEjercicio(new EjercicioEntity(
                    0,
                    "Elevación de talón",
                    "Pantorrilla",
                    "https://youtu.be/cXMF3q9fe9A"));
            GFGServiceImpl.añadirEjercicio(new EjercicioEntity(
                    0,
                    "Curl con barra recta",
                    "Bíceps",
                    "https://youtu.be/JIaHBtDcaeo"));
            GFGServiceImpl.añadirEjercicio(new EjercicioEntity(
                    0,
                    "Curl con barra zeta",
                    "Bíceps",
                    "https://youtu.be/b8nB33AAYJE"));
            GFGServiceImpl.añadirEjercicio(new EjercicioEntity(
                    0,
                    "Curl martillo",
                    "Bíceps",
                    "https://youtu.be/0vM1CRNsoDg"));
            GFGServiceImpl.añadirEjercicio(new EjercicioEntity(
                    0,
                    "Curl predicador",
                    "Bíceps",
                    "https://youtu.be/JuI1scl85ks"));
            GFGServiceImpl.añadirEjercicio(new EjercicioEntity(
                    0,
                    "Chin-Ups",
                    "Bíceps",
                    "https://youtu.be/ygLAn1E05YU"));
            GFGServiceImpl.añadirEjercicio(new EjercicioEntity(
                    0,
                    "Extensión de codos con polea",
                    "Tríceps",
                    "https://youtu.be/8JLwQur5QUQ"));
            GFGServiceImpl.añadirEjercicio(new EjercicioEntity(
                    0,
                    "Press francés",
                    "Tríceps",
                    "https://youtu.be/y02BnAE92ng"));
            GFGServiceImpl.añadirEjercicio(new EjercicioEntity(
                    0,
                    "Press banca cerrado",
                    "Tríceps",
                    "https://youtu.be/uNxlfU09nwU"));
            GFGServiceImpl.añadirEjercicio(new EjercicioEntity(
                    0,
                    "Fondos en banca",
                    "Tríceps",
                    "https://youtu.be/G2r4Ct9bLes"));
            GFGServiceImpl.añadirEjercicio(new EjercicioEntity(
                    0,
                    "Press militar",
                    "Hombro",
                    "https://youtu.be/LLIPZ38JALU"));
            GFGServiceImpl.añadirEjercicio(new EjercicioEntity(
                    0,
                    "Elevaciones frontales",
                    "Hombro",
                    "https://youtu.be/UKForOsGETs"));
            GFGServiceImpl.añadirEjercicio(new EjercicioEntity(
                    0,
                    "Elevaciones laterales",
                    "Hombro",
                    "https://youtu.be/3aSETBpm4-Y"));
            GFGServiceImpl.añadirEjercicio(new EjercicioEntity(
                    0,
                    "Flys invertidos",
                    "Hombro",
                    "https://youtu.be/29AM-enz1tA"));
            GFGServiceImpl.añadirEjercicio(new EjercicioEntity(
                    0,
                    "Crunch",
                    "Abdominales",
                    "https://youtu.be/qekoPpYw9m8"));
            GFGServiceImpl.añadirEjercicio(new EjercicioEntity(
                    0,
                    "Plancha",
                    "Abdominales",
                    ""));
            GFGServiceImpl.añadirEjercicio(new EjercicioEntity(
                    0,
                    "Rueda abdominal",
                    "Abdominales",
                    "https://youtu.be/JgVFa1KdnJg"));
            GFGServiceImpl.añadirEjercicio(new EjercicioEntity(
                    0,
                    "Crunch invertido",
                    "Abdominales",
                    "https://youtu.be/2Zn5L062e6Y"));
            GFGServiceImpl.añadirEjercicio(new EjercicioEntity(
                    0,
                    "Elevaciones de pierna",
                    "Abdominales",
                    "https://youtu.be/7dHQ_sz2cZE"));
        }


        // ::::: INTRODUCCIÓN DE COMIDAS EN LA BASE DE DATOS ::::: //

        if (GFGServiceImpl.listadoComida().size() == 0) {
            GFGServiceImpl.añadirComida(new ComidaEntity(
                    0,
                    "Muesli casero",
                    "https://youtu.be/ZpLc0dYmYM8"
            ));
            GFGServiceImpl.añadirComida(new ComidaEntity(
                    0,
                    "Tortilla completa",
                    "https://youtu.be/LI98gRIrRl8"
            ));
            GFGServiceImpl.añadirComida(new ComidaEntity(
                    0,
                    "Banana Split con crema de cacahuete",
                    "https://youtu.be/eyGMdKmK5ZM"
            ));
            GFGServiceImpl.añadirComida(new ComidaEntity(
                    0,
                    "Pizza light de pimientos y mozzarella",
                    "https://youtu.be/Z3b52CeFKlE"
            ));
            GFGServiceImpl.añadirComida(new ComidaEntity(
                    0,
                    "Porridge o gachas de avena con manzana",
                    "https://youtu.be/6E5YgP8BHnE"
            ));
        }
    }
}
