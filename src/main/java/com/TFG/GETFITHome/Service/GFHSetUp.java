package com.TFG.GETFITHome.Service;

import com.TFG.GETFITHome.Dto.Comidas.ComidaEntity;
import com.TFG.GETFITHome.Dto.Ejercicio.EjercicioEntity;
import com.TFG.GETFITHome.Dto.Usuario.UsuarioEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;

@Component
public class GFHSetUp implements ApplicationRunner {

    @Autowired
    private GFHService gfhServiceImpl;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        if (gfhServiceImpl.listadoUsuarios().size() == 0) {
            gfhServiceImpl.añadirUsuario(new UsuarioEntity(
                    0,
                    0,
                    "David",
                    "Lima",
                    "Rodriguez",
                    "DavidTrainer@Gmail.com",
                    "1992-10-15",
                    180,
                    70,
                    "ES521234567890",
                    "1234"));

            gfhServiceImpl.añadirUsuario(new UsuarioEntity(
                    0,
                    1,
                    "Igor",
                    "Boullosa",
                    "García",
                    "IgorBoullosa@Gmail.com",
                    "1991-09-30",
                    181,
                    70,
                    "ES520987654321",
                    "5678"));

            gfhServiceImpl.añadirUsuario(new UsuarioEntity(
                    0,
                    1,
                    "Carlos",
                    "Castillo",
                    "García",
                    "CarlosCastillo@Gmail.com",
                    "2001-06-01",
                    181,
                    71,
                    "ES520987654322",
                    "56783"));
        }


        // ::::: INTRODUCCIÓN DE EJERCICIOS EN LA BASE DE DATOS ::::: //

        if (gfhServiceImpl.listadoEjercicios().size() == 0) {
            gfhServiceImpl.añadirEjercicio(new EjercicioEntity(
                    0,
                    "Press banca",
                    "Pectorales",
                    "https://youtu.be/eqLT5AE9YCU"));
            gfhServiceImpl.añadirEjercicio(new EjercicioEntity(
                    0,
                    "Lagartijas",
                    "Pectorales",
                    "https://youtu.be/PYLecpZJGpE"));
            gfhServiceImpl.añadirEjercicio(new EjercicioEntity(
                    0,
                    "Fondos",
                    "Pectorales",
                    "https://youtu.be/_NgpDQ1ojys"));
            gfhServiceImpl.añadirEjercicio(new EjercicioEntity(
                    0,
                    "Press inclinado",
                    "Pectorales",
                    "https://youtu.be/-VtOLVAfoIU"));
            gfhServiceImpl.añadirEjercicio(new EjercicioEntity(
                    0,
                    "Press con mancuerna",
                    "Pectorales",
                    "https://youtu.be/2AcLs-Tr85M"));
            gfhServiceImpl.añadirEjercicio(new EjercicioEntity(
                    0,
                    "Cruce de poleas",
                    "Pectorales",
                    "https://youtu.be/XnaMi2Gb_9Q"));
            gfhServiceImpl.añadirEjercicio(new EjercicioEntity(
                    0,
                    "Dominadas",
                    "Espalda",
                    "https://youtu.be/ouvnonII-Ws"));
            gfhServiceImpl.añadirEjercicio(new EjercicioEntity(
                    0,
                    "Jalones al pecho",
                    "Espalda",
                    "https://youtu.be/DzvOf1fqGDA"));
            gfhServiceImpl.añadirEjercicio(new EjercicioEntity(
                    0,
                    "Remo con barra",
                    "Espalda",
                    "https://youtu.be/3uiWjik2yEQ"));
            gfhServiceImpl.añadirEjercicio(new EjercicioEntity(
                    0,
                    "Remo invertido",
                    "Espalda",
                    "https://youtu.be/7Qf8GOf--a0"));
            gfhServiceImpl.añadirEjercicio(new EjercicioEntity(
                    0,
                    "Peso muerto",
                    "Espalda",
                    "https://youtu.be/_LJUalLAQ_4"));
            gfhServiceImpl.añadirEjercicio(new EjercicioEntity(
                    0,
                    "Encogiminetos con barra",
                    "Espalda",
                    "https://youtu.be/TKrEp0jgeFE"));
            gfhServiceImpl.añadirEjercicio(new EjercicioEntity(
                    0,
                    "Sentadilla con barra",
                    "Cuádriceps",
                    "https://youtu.be/SNW8HAlM2Iw"));
            gfhServiceImpl.añadirEjercicio(new EjercicioEntity(
                    0,
                    "Sentadilla frontal",
                    "Cuádriceps",
                    "https://youtu.be/GCMPzpCqPoo"));
            gfhServiceImpl.añadirEjercicio(new EjercicioEntity(
                    0,
                    "Leg press",
                    "Cuádriceps",
                    "https://youtu.be/aXokNaCJB18"));
            gfhServiceImpl.añadirEjercicio(new EjercicioEntity(
                    0,
                    "Desplantes",
                    "Cuádriceps",
                    "https://youtu.be/NurJKlGfVzE"));
            gfhServiceImpl.añadirEjercicio(new EjercicioEntity(
                    0,
                    "Sentadilla búlgara",
                    "Cuádriceps",
                    "https://youtu.be/K-6DG1hcHzU"));
            gfhServiceImpl.añadirEjercicio(new EjercicioEntity(
                    0,
                    "Extensiones",
                    "Cuádriceps",
                    "https://youtu.be/HXqas5IpC8k"));
            gfhServiceImpl.añadirEjercicio(new EjercicioEntity(
                    0,
                    "Hip thrust",
                    "Glúteos",
                    "https://youtu.be/2LKqiecERXw"));
            gfhServiceImpl.añadirEjercicio(new EjercicioEntity(
                    0,
                    "Pull through",
                    "Glúteos",
                    "https://youtu.be/OkcryKUZTZs"));
            gfhServiceImpl.añadirEjercicio(new EjercicioEntity(
                    0,
                    "Frog pumps",
                    "Glúteos",
                    "https://youtu.be/KvdJEqifOLk"));
            gfhServiceImpl.añadirEjercicio(new EjercicioEntity(
                    0,
                    "Hiperextensiones",
                    "Glúteos",
                    "https://youtu.be/PicwGUbAjb4"));
            gfhServiceImpl.añadirEjercicio(new EjercicioEntity(
                    0,
                    "Patada de glúteo",
                    "Glúteos",
                    "https://youtu.be/es1GiFH2qYw"));
            gfhServiceImpl.añadirEjercicio(new EjercicioEntity(
                    0,
                    "Peso muerto rumano",
                    "Femorales",
                    "https://youtu.be/NIng2JWF1Rs"));
            gfhServiceImpl.añadirEjercicio(new EjercicioEntity(
                    0,
                    "Curl en máquina",
                    "Femorales",
                    "https://youtu.be/pffYI5NpYo8"));
            gfhServiceImpl.añadirEjercicio(new EjercicioEntity(
                    0,
                    "Curl sentado",
                    "Femorales",
                    "https://youtu.be/26-ULvk4bjU"));
            gfhServiceImpl.añadirEjercicio(new EjercicioEntity(
                    0,
                    "Slide curl",
                    "Femorales",
                    "https://youtu.be/kkkTfzi2gj4"));
            gfhServiceImpl.añadirEjercicio(new EjercicioEntity(
                    0,
                    "Curl nórdico",
                    "Femorales",
                    "https://youtu.be/U7zU0eHQRaw"));
            gfhServiceImpl.añadirEjercicio(new EjercicioEntity(
                    0,
                    "Elevación de talón",
                    "Pantorrilla",
                    "https://youtu.be/cXMF3q9fe9A"));
            gfhServiceImpl.añadirEjercicio(new EjercicioEntity(
                    0,
                    "Curl con barra recta",
                    "Bíceps",
                    "https://youtu.be/JIaHBtDcaeo"));
            gfhServiceImpl.añadirEjercicio(new EjercicioEntity(
                    0,
                    "Curl con barra zeta",
                    "Bíceps",
                    "https://youtu.be/b8nB33AAYJE"));
            gfhServiceImpl.añadirEjercicio(new EjercicioEntity(
                    0,
                    "Curl martillo",
                    "Bíceps",
                    "https://youtu.be/0vM1CRNsoDg"));
            gfhServiceImpl.añadirEjercicio(new EjercicioEntity(
                    0,
                    "Curl predicador",
                    "Bíceps",
                    "https://youtu.be/JuI1scl85ks"));
            gfhServiceImpl.añadirEjercicio(new EjercicioEntity(
                    0,
                    "Chin-Ups",
                    "Bíceps",
                    "https://youtu.be/ygLAn1E05YU"));
            gfhServiceImpl.añadirEjercicio(new EjercicioEntity(
                    0,
                    "Extensión de codos con polea",
                    "Tríceps",
                    "https://youtu.be/8JLwQur5QUQ"));
            gfhServiceImpl.añadirEjercicio(new EjercicioEntity(
                    0,
                    "Press francés",
                    "Tríceps",
                    "https://youtu.be/y02BnAE92ng"));
            gfhServiceImpl.añadirEjercicio(new EjercicioEntity(
                    0,
                    "Press banca cerrado",
                    "Tríceps",
                    "https://youtu.be/uNxlfU09nwU"));
            gfhServiceImpl.añadirEjercicio(new EjercicioEntity(
                    0,
                    "Fondos en banca",
                    "Tríceps",
                    "https://youtu.be/G2r4Ct9bLes"));
            gfhServiceImpl.añadirEjercicio(new EjercicioEntity(
                    0,
                    "Press militar",
                    "Hombro",
                    "https://youtu.be/LLIPZ38JALU"));
            gfhServiceImpl.añadirEjercicio(new EjercicioEntity(
                    0,
                    "Elevaciones frontales",
                    "Hombro",
                    "https://youtu.be/UKForOsGETs"));
            gfhServiceImpl.añadirEjercicio(new EjercicioEntity(
                    0,
                    "Elevaciones laterales",
                    "Hombro",
                    "https://youtu.be/3aSETBpm4-Y"));
            gfhServiceImpl.añadirEjercicio(new EjercicioEntity(
                    0,
                    "Flys invertidos",
                    "Hombro",
                    "https://youtu.be/29AM-enz1tA"));
            gfhServiceImpl.añadirEjercicio(new EjercicioEntity(
                    0,
                    "Crunch",
                    "Abdominales",
                    "https://youtu.be/qekoPpYw9m8"));
            gfhServiceImpl.añadirEjercicio(new EjercicioEntity(
                    0,
                    "Plancha",
                    "Abdominales",
                    ""));
            gfhServiceImpl.añadirEjercicio(new EjercicioEntity(
                    0,
                    "Rueda abdominal",
                    "Abdominales",
                    "https://youtu.be/JgVFa1KdnJg"));
            gfhServiceImpl.añadirEjercicio(new EjercicioEntity(
                    0,
                    "Crunch invertido",
                    "Abdominales",
                    "https://youtu.be/2Zn5L062e6Y"));
            gfhServiceImpl.añadirEjercicio(new EjercicioEntity(
                    0,
                    "Elevaciones de pierna",
                    "Abdominales",
                    "https://youtu.be/7dHQ_sz2cZE"));
        }


        // ::::: INTRODUCCIÓN DE COMIDAS EN LA BASE DE DATOS ::::: //

        if (gfhServiceImpl.listadoComida().size() == 0) {
            gfhServiceImpl.añadirComida(new ComidaEntity(
                    0,
                    "Muesli casero",
                    "https://youtu.be/ZpLc0dYmYM8"
            ));
            gfhServiceImpl.añadirComida(new ComidaEntity(
                    0,
                    "Tortilla completa",
                    "https://youtu.be/LI98gRIrRl8"
            ));
            gfhServiceImpl.añadirComida(new ComidaEntity(
                    0,
                    "Banana Split con crema de cacahuete",
                    "https://youtu.be/eyGMdKmK5ZM"
            ));
            gfhServiceImpl.añadirComida(new ComidaEntity(
                    0,
                    "Pizza light de pimientos y mozzarella",
                    "https://youtu.be/Z3b52CeFKlE"
            ));
            gfhServiceImpl.añadirComida(new ComidaEntity(
                    0,
                    "Porridge o gachas de avena con manzana",
                    "https://youtu.be/6E5YgP8BHnE"
            ));
        }
    }
}
