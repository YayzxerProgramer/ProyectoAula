package Controller;

import Model.AseoPersonal;
import Model.Bebidas;
import Model.CuidadoSexual;
import Model.Medicamentos;

public class ProductosController {

    public static Medicamentos[] medicamentos = new Medicamentos[27];
    public static Bebidas[] bebidas = new Bebidas[100];
    public static CuidadoSexual[] cuidadoSexual = new CuidadoSexual[100];
    public static AseoPersonal[] aseoPersonal = new AseoPersonal[100];

    public static void crProductos() {
        medicamentos[0] = new Medicamentos("Acetaminofen", "", 1000, "Tabletas", 100, "Bayer", "12/12/2022", "1234", "Dolor de cabeza", false);
        medicamentos[1] = new Medicamentos("Naproxeno", "", 2000, "Tabletas", 100, "Bayer", "12/12/2022", "1234", "Dolor de cabeza", false);
        medicamentos[2] = new Medicamentos("Xraydol", "", 3000, "Tabletas", 100, "Bayer", "12/12/2022", "1234", "Dolor de cabeza", false);
        medicamentos[3] = new Medicamentos("Ibuprofeno", "", 4000, "Tabletas", 100, "Bayer", "12/12/2022", "1234", "Dolor de cabeza", false);
        medicamentos[4] = new Medicamentos("Diclofenaco", "", 5000, "Tabletas", 100, "Bayer", "12/12/2022", "1234", "Dolor de cabeza", false);
        medicamentos[5] = new Medicamentos("Sevedol", "", 6000, "Tabletas", 100, "Bayer", "12/12/2022", "1234", "Dolor de cabeza", false);
        medicamentos[6] = new Medicamentos("Dolex", "", 7000, "Tabletas", 100, "Bayer", "12/12/2022", "1234", "Dolor de cabeza", false);
        medicamentos[7] = new Medicamentos("Cefalexina", "", 8000, "Capsulas/Antibioticos", 100, "Bayer", "12/12/2022", "1234", "Dolor de cabeza", false);
        medicamentos[8] = new Medicamentos("Ampicilina", "", 9000, "Capsulas/Antibioticos", 100, "Bayer", "12/12/2022", "1234", "Dolor de cabeza", false);
        medicamentos[9] = new Medicamentos("Omeprazol", "", 10000, "Capsulas/Antibioticos", 100, "Bayer", "12/12/2022", "1234", "Dolor de cabeza", false);
        medicamentos[10] = new Medicamentos("Noxpirin", "", 11000, "Capsulas/Antibioticos", 100, "Bayer", "12/12/2022", "1234", "Dolor de cabeza", false);
        medicamentos[11] = new Medicamentos("Tramaodol", "", 12000, "Capsulas/Antibioticos", 100, "Bayer", "12/12/2022", "1234", "Dolor de cabeza", false);
        medicamentos[12] = new Medicamentos("Oripol", "", 13000, "Capsulas/Antibioticos", 100, "Bayer", "12/12/2022", "1234", "Dolor de cabeza", false);
        medicamentos[13] = new Medicamentos("Mieltertos", "", 14000, "Jarabes", 100, "Bayer", "12/12/2022", "1234", "Dolor de cabeza", false);
        medicamentos[14] = new Medicamentos("Acetaminofen", "", 15000, "Jarabes", 100, "Bayer", "12/12/2022", "1234", "Dolor de cabeza", false);
        medicamentos[15] = new Medicamentos("Dolex", "", 16000, "Jarabes", 100, "Bayer", "12/12/2022", "1234", "Dolor de cabeza", false);
        medicamentos[16] = new Medicamentos("Tucoldex", "", 17000, "Jarabes", 100, "Bayer", "12/12/2022", "1234", "Dolor de cabeza", false);
        medicamentos[17] = new Medicamentos("Apetiform", "", 18000, "Jarabes", 100, "Bayer", "12/12/2022", "1234", "Dolor de cabeza", false);
        medicamentos[18] = new Medicamentos("Disolvon", "", 19000, "Suspencion", 100, "Bayer", "12/12/2022", "1234", "Dolor de cabeza", false);
        medicamentos[19] = new Medicamentos("Ampicilina", "", 20000, "Suspencion", 100, "Bayer", "12/12/2022", "1234", "Dolor de cabeza", false);
        medicamentos[20] = new Medicamentos("Cefalexina", "", 21000, "Suspencion", 100, "Bayer", "12/12/2022", "1234", "Dolor de cabeza", false);
        medicamentos[21] = new Medicamentos("Noproxeno", "", 22000, "Suspencion", 100, "Bayer", "12/12/2022", "1234", "Dolor de cabeza", false);
        medicamentos[22] = new Medicamentos("Fluimicil", "", 23000, "Suspencion", 100, "Bayer", "12/12/2022", "1234", "Dolor de cabeza", false);
        medicamentos[23] = new Medicamentos("VickVaporup", "", 24000, "Ungüentos", 100, "Bayer", "12/12/2022", "1234", "Dolor de cabeza", false);
        medicamentos[24] = new Medicamentos("Mentolin", "", 25000, "Ungüentos", 100, "Bayer", "12/12/2022", "1234", "Dolor de cabeza", false);
        medicamentos[25] = new Medicamentos("Nizoder", "", 26000, "Ungüentos", 100, "Bayer", "12/12/2022", "1234", "Dolor de cabeza", false);
        medicamentos[26] = new Medicamentos("Calendula", "", 27000, "Ungüentos", 100, "Bayer", "12/12/2022", "1234", "Dolor de cabeza", false);

        bebidas[0] = new Bebidas("CocaCola", "Gaseosa", 6000, "Gaseosa", 1000);
        bebidas[1] = new Bebidas("Pepsi", "Gaseosa", 5800, "Gaseosa", 1000);
        bebidas[2] = new Bebidas("Sprite", "Gaseosa", 5700, "Gaseosa", 1000);
        bebidas[3] = new Bebidas("Fanta", "Gaseosa", 5900, "Gaseosa", 1000);
        bebidas[4] = new Bebidas("Manzana Postobón", "Gaseosa", 5600, "Gaseosa", 1000);
        bebidas[5] = new Bebidas("Agua Cristal", "Agua", 3000, "Agua", 500);
        bebidas[6] = new Bebidas("Agua Manantial", "Agua", 3100, "Agua", 500);
        bebidas[7] = new Bebidas("Electrolit", "Hidratante", 8500, "Hidratante", 625);
        bebidas[8] = new Bebidas("Gatorade", "Hidratante", 7000, "Hidratante", 600);
        bebidas[9] = new Bebidas("Powerade", "Hidratante", 7200, "Hidratante", 600);
        bebidas[10] = new Bebidas("Red Bull", "Energética", 9000, "Energética", 250);
        bebidas[11] = new Bebidas("Monster", "Energética", 9500, "Energética", 500);
        bebidas[12] = new Bebidas("Vive 100", "Energética", 5000, "Energética", 400);
        bebidas[13] = new Bebidas("Lipton Té Frío", "Té", 4500, "Té", 500);
        bebidas[14] = new Bebidas("Nestea", "Té", 4600, "Té", 500);
        bebidas[15] = new Bebidas("Jugo Del Valle Mango", "Jugo", 5500, "Jugo", 500);

        aseoPersonal[0] = new AseoPersonal("Jabón de tocador", "Jabón de tocador", 1000, "Jabón", 1);
        aseoPersonal[1] = new AseoPersonal("Gel de baño", "Gel de baño", 2000, "Gel", 1);
        aseoPersonal[2] = new AseoPersonal("Desodorante", "Desodorante", 3000, "Desodorante", 1);
        aseoPersonal[3] = new AseoPersonal("Talco corporal", "Talco corporal", 4000, "Talco", 1);
        aseoPersonal[4] = new AseoPersonal("Crema dental", "Crema dental", 5000, "Crema dental", 1);
        aseoPersonal[5] = new AseoPersonal("Cepillo de dientes", "Cepillo de dientes", 6000, "Cepillo de dientes", 1);
        aseoPersonal[6] = new AseoPersonal("Enjuague bucal", "Enjuague bucal", 7000, "Enjuague bucal", 1);
        aseoPersonal[7] = new AseoPersonal("Hilo dental", "Hilo dental", 8000, "Hilo dental", 1);
        aseoPersonal[8] = new AseoPersonal("Champú", "Champú", 9000, "Champú", 1);
        aseoPersonal[9] = new AseoPersonal("Acondicionador", "Acondicionador", 10000, "Acondicionador", 1);
        aseoPersonal[10] = new AseoPersonal("Tratamientos capilares", "Tratamientos capilares", 11000, "Tratamientos capilares", 1);
        aseoPersonal[11] = new AseoPersonal("Gel o cera para el cabello", "Gel o cera para el cabello", 12000, "Gel o cera para el cabello", 1);
        aseoPersonal[12] = new AseoPersonal("Toallas higiénicas", "Toallas higiénicas", 13000, "Toallas higiénicas", 1);
        aseoPersonal[13] = new AseoPersonal("Protectores diarios", "Protectores diarios", 14000, "Protectores diarios", 1);
        aseoPersonal[14] = new AseoPersonal("Jabón íntimo", "Jabón íntimo", 15000, "Jabón íntimo", 1);
        aseoPersonal[15] = new AseoPersonal("Papel higiénico", "Papel higiénico", 16000, "Papel higiénico", 1);

        cuidadoSexual[0] = new CuidadoSexual("Preservativos", "Preservativos", 1000, "Preservativos", 1);
        cuidadoSexual[1] = new CuidadoSexual("Lubricantes", "Lubricantes", 2000, "Lubricantes", 1);
        cuidadoSexual[2] = new CuidadoSexual("Vibradores", "Vibradores", 3000, "Vibradores", 1);
        cuidadoSexual[3] = new CuidadoSexual("Anillos vibradores", "Anillos vibradores", 4000, "Anillos", 1);
        cuidadoSexual[4] = new CuidadoSexual("Vigorizantes", "Vigorizantes", 5000, "Vigorizantes", 1);
        cuidadoSexual[5] = new CuidadoSexual("Juguetes sexuales", "Juguetes sexuales", 6000, "Jugetes sexuales", 1);
        cuidadoSexual[6] = new CuidadoSexual("Afrodisiacos", "Afrodisiacos", 7000, "Afrodisiacos", 1);
        cuidadoSexual[7] = new CuidadoSexual("Estimulantes", "Estimulantes", 8000, "Estimulantes", 1);
        cuidadoSexual[8] = new CuidadoSexual("Feromonas", "Feromonas", 9000, "Feromonas", 1);
        cuidadoSexual[9] = new CuidadoSexual("Aceites y lubricantes", "Aceites y lubricantes", 10000, "Aceites y lubricantes", 1);
        cuidadoSexual[10] = new CuidadoSexual("Kits eróticos", "kits eróticos", 11000, "Kit erótico", 1);
        cuidadoSexual[11] = new CuidadoSexual("Juegos de pareja", "Juegos de pareja", 12000, "Juegosde pareja", 1);
        cuidadoSexual[12] = new CuidadoSexual("Lencería eróticos", "Lenceria erótica", 13000, "Lenceria erótica", 1);
        cuidadoSexual[13] = new CuidadoSexual("Bromas y despedidas", "Bromas y despedidas", 14000, "Bromas y despedidas", 1);
        cuidadoSexual[14] = new CuidadoSexual("Fetiches", "Fetiches", 15000, "Fetiches", 1);
        cuidadoSexual[15] = new CuidadoSexual("Juguetes anal", "Juguetes anal", 16000, "Jugetes anal", 1);
    }

}
