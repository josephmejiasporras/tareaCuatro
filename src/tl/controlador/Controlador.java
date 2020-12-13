package tl.controlador;

import UI.UI;
import bl.entidades.Administrativo;
import bl.entidades.Audio;
import bl.entidades.Estudiante;
import bl.entidades.Material;
import bl.entidades.Otro;
import bl.entidades.Prestamo;
import bl.entidades.Profesor;
import bl.entidades.Texto;
import bl.entidades.Usuario;
import bl.entidades.Video;
import bl.gestor.Gestor;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class Controlador {

    private final UI ui = new UI();
    private final Gestor gestor = new Gestor();

    public void ejecutar() throws SQLException, IOException {

        boolean ward = true;
        int action = 0;
        while (ward) {
            switch (action) {
                case 0:
                    action = ui.menu(true);
                    break;
                case 1:
                    registrarUsuario();
                    action = 0;
                    break;
                case 2:
                    listarUsuarios();
                    action = 0;
                    break;
                case 3:
                    registrarMaterial();
                    action = 0;
                    break;
                case 4:
                    listarMateriales();
                    action = 0;
                    break;
                case 6:
                    System.out.println("Adiós!");
                    ward = false;
                    break;
                case -1:
                    action = ui.menu(false);
                default:

            }
        }

    }

    private void registrarUsuario() {
        ui.imprimir("\nRegistrar Usuario"
                + "\nPresione 1 para registrar un Estudiante"
                + "\nPresione 2 para registrar un Profesor"
                + "\nPresione 3 para registrar un Administrativo"
                + "\nPresione cualquier otra tecla para cancelar");
        switch (ui.readInt()) {
            case 1:
                ui.imprimir("\nIngrese el nombre del estudiante:");
                String nombreEstudiante = ui.readString();
                ui.imprimir("\nIngrese los apellidos del estudiante:");
                String apellidosEstudiante = ui.readString();
                ui.imprimir("\nIngrese el ID del estudiante:");
                String idEstudiante = ui.readString();
                ui.imprimir("\nIngrese la carrera del estudiante:");
                String carreraEstudiante = ui.readString();
                ui.imprimir("\nIngrese la cantidad de creditos actuales del estudiante:");
                int creditosEstudiante = ui.readInt();
                Estudiante nuevoEstudiante = new Estudiante(nombreEstudiante, apellidosEstudiante, idEstudiante, carreraEstudiante, creditosEstudiante);
                gestor.agregarUsuario(nuevoEstudiante);
                break;
            case 2:
                ui.imprimir("\nIngrese el nombre del Profesor:");
                String nombreProfesor = ui.readString();
                ui.imprimir("\nIngrese los apellidos del Profesor:");
                String apellidosProfesor = ui.readString();
                ui.imprimir("\nIngrese el ID del Profesor:");
                String idProfesor = ui.readString();
                ui.imprimir("\nIngrese el tipo de contrato del profesor:");
                String contratoProfesor = ui.readString();
                ui.imprimir("\nIngrese la fecha de contratacion del profesor:");
                String fechaProfesor = ui.readString();
                Profesor nuevoProfesor = new Profesor(nombreProfesor, apellidosProfesor, idProfesor, contratoProfesor, LocalDate.parse(fechaProfesor));
                gestor.agregarUsuario(nuevoProfesor);
                break;
            case 3:
                ui.imprimir("\nIngrese el nombre del Administrativo:");
                String nombreAdministrativo = ui.readString();
                ui.imprimir("\nIngrese los apellidos del Administrativo:");
                String apellidosAdministrativo = ui.readString();
                ui.imprimir("\nIngrese el ID del Administrativo:");
                String idAdministrativo = ui.readString();
                ui.imprimir("\nIngrese el tipo de nombramiento del Administrativo:");
                String nombramientoAdministrativo = ui.readString();
                ui.imprimir("\nIngrese las horas semanales del Administrativo:");
                double horasSemanales = ui.readDouble();
                Administrativo nuevoAdministrativo = new Administrativo(nombramientoAdministrativo, horasSemanales, nombreAdministrativo, apellidosAdministrativo, idAdministrativo);
                gestor.agregarUsuario(nuevoAdministrativo);
                break;
            default:
                break;
        }
    }

    private void registrarMaterial() {
        ui.imprimir("\nRegistrar Material"
                + "\nPresione 1 para registrar un Texto"
                + "\nPresione 2 para registrar un Audio"
                + "\nPresione 3 para registrar un Video"
                + "\nPresione 4 para registrar Otro"
                + "\nPresione cualquier otra tecla para cancelar");
        switch (ui.readInt()) {
            case 1:
                ui.imprimir("\nIngrese la signatura del Texto:");
                String signaturaTexto = ui.readString();
                ui.imprimir("\nIngrese el titulo del Texto:");
                String tituloTexto = ui.readString();
                ui.imprimir("\nIngrese el tema del texto:");
                String temaTexto = ui.readString();
                ui.imprimir("\nIngrese el idioma del texto: (Opcional)");
                String idiomaTexto = ui.readString();
                ui.imprimir("\nIngrese el nombre del autor del Texto:");
                String autorTexto = ui.readString();
                ui.imprimir("\nIngrese la fecha de publicacion del texto:");
                boolean thisdate2 = false;
                LocalDate FechapublicacionTexto = LocalDate.now();
                do {
                    if (thisdate2) {
                        System.out.println("invalido!");
                    }
                    try {
                        FechapublicacionTexto = LocalDate.parse(ui.readString());
                        thisdate2 = true;
                    } catch (Exception e) {

                    }
                } while (!thisdate2);
                ui.imprimir("\nIngrese el numero de paginas del texto:");
                String paginasTexto = ui.readString();
                ui.imprimir("\nIngrese la fecha de Compra del texto:");
                boolean thisdate = false;
                LocalDate FechaCompraTexto = LocalDate.now();
                do {
                    if (thisdate) {
                        System.out.println("invalido!");
                    }
                    try {
                        FechaCompraTexto = LocalDate.parse(ui.readString());
                        thisdate = true;
                    } catch (Exception e) {

                    }
                } while (!thisdate);

                ui.imprimir("\nEl texto está restringido? Responda Si o cualquier otra cosa para No");
                String restringidoLnTexto = ui.readString();
                boolean restringidoTexto;
                if (restringidoLnTexto.toLowerCase().equals("si")) {
                    restringidoTexto = true;
                } else {
                    restringidoTexto = false;
                }

                Texto nuevoTexto = new Texto(tituloTexto, autorTexto, FechapublicacionTexto, Integer.parseInt(paginasTexto), signaturaTexto, FechaCompraTexto, restringidoTexto, temaTexto, idiomaTexto);
                gestor.agregarMaterial(nuevoTexto);
                break;

            case 2:
                ui.imprimir("\nIngrese la signatura del Audio:");
                String signaturaAudio = ui.readString();
                ui.imprimir("\nIngrese la duracion del Audio:");
                int duracionAudio;
                boolean check = false;
                do {
                    if (!check) {
                        System.out.println("debe ser un numero entero!");
                    }
                    duracionAudio = ui.readInt();
                } while (duracionAudio == -1);
                ui.imprimir("\nIngrese la fecha de Compra del audio:");
                boolean thisdateaudio = false;
                LocalDate FechaCompraAudio = LocalDate.now();
                do {
                    if (thisdateaudio) {
                        System.out.println("invalido!");
                    }
                    try {
                        FechaCompraAudio = LocalDate.parse(ui.readString());
                        thisdateaudio = true;
                    } catch (Exception e) {

                    }
                } while (!thisdateaudio);

                ui.imprimir("\nIngrese el idioma del Audio: (Opcional)");
                String idiomaAudio = ui.readString();
                ui.imprimir("\nIngrese el formato del Audio:");
                String formatoAudio = ui.readString();
                ui.imprimir("\nIngrese el tema del Audio:");
                String temaAudio = ui.readString();
                ui.imprimir("\nEl Audio está restringido? Responda Si o cualquier otra cosa para No");
                String restringidoLnAudio = ui.readString();
                boolean restringidoAudio;
                if (restringidoLnAudio.toLowerCase().equals("si")) {
                    restringidoAudio = true;
                } else {
                    restringidoAudio = false;
                }

                Audio nuevoAudio = new Audio();
                nuevoAudio.setDuracion(duracionAudio);

                nuevoAudio.setFormato(formatoAudio);
                nuevoAudio.setFechaCompra(FechaCompraAudio);
                nuevoAudio.setIdioma(idiomaAudio);
                nuevoAudio.setSignatura(signaturaAudio);
                nuevoAudio.setRestringido(restringidoAudio);
                nuevoAudio.setTema(temaAudio);
                gestor.agregarMaterial(nuevoAudio);
                break;
            case 3:
                ui.imprimir("\nIngrese la signatura del Video:");
                String signaturaVideo = ui.readString();
                ui.imprimir("\nIngrese la duracion del Video:");
                int duracionVideo;
                boolean checkVideo = false;
                do {
                    if (!checkVideo) {
                        System.out.println("debe ser un numero entero!");
                    }
                    duracionVideo = ui.readInt();
                } while (duracionVideo == -1);
                ui.imprimir("\nIngrese el director del Video:");
                String directorVideo = ui.readString();
                ui.imprimir("\nIngrese el idioma del Video: (Opcional)");
                String idiomaVideo = ui.readString();
                ui.imprimir("\nIngrese el formato del Video:");
                String formatoVideo = ui.readString();
                ui.imprimir("\nIngrese el tema del Video:");
                String temaVideo = ui.readString();
                ui.imprimir("\nIngrese la fecha de Compra del Video:");
                LocalDate fechaCompraVideo = LocalDate.now();
                boolean thisdatevideo = false;

                do {
                    if (thisdatevideo) {
                        System.out.println("invalido!");
                    }
                    try {
                        fechaCompraVideo = LocalDate.parse(ui.readString());
                        thisdatevideo = true;
                    } catch (Exception e) {

                    }
                } while (!thisdatevideo);
                ui.imprimir("\nEl Video está restringido? Responda Si o cualquier otra cosa para No");
                String restringidoLnVideo = ui.readString();
                boolean restringidoVideo;
                if (restringidoLnVideo.toLowerCase().equals("si")) {
                    restringidoVideo = true;
                } else {
                    restringidoVideo = false;
                }

                Video nuevoVideo = new Video();

                nuevoVideo.setDuracion(duracionVideo);
                nuevoVideo.setFormato(formatoVideo);
                nuevoVideo.setFechaCompra(fechaCompraVideo);
                nuevoVideo.setIdioma(idiomaVideo);
                nuevoVideo.setSignatura(signaturaVideo);
                nuevoVideo.setRestringido(restringidoVideo);
                nuevoVideo.setTema(temaVideo);
                nuevoVideo.setDirector(directorVideo);
                gestor.agregarMaterial(nuevoVideo);
                break;
            case 4:
                ui.imprimir("\nIngrese la signatura del Material:");
                String signaturaOtro = ui.readString();
                ui.imprimir("\nIngrese la descripcion del Material:");
                String descripcionOtro = ui.readString();
                ui.imprimir("\nIngrese el tema del Material:");
                String temaOtro = ui.readString();
                ui.imprimir("\nIngrese la fecha de Compra del Material:");
                LocalDate fechaCompraOtro = LocalDate.now();
                boolean thisdateotro = false;

                do {
                    if (thisdateotro) {
                        System.out.println("invalido!");
                    }
                    try {
                        fechaCompraOtro = LocalDate.parse(ui.readString());
                        thisdateotro = true;
                    } catch (Exception e) {

                    }
                } while (!thisdateotro);
                ui.imprimir("\nEl Material está restringido? Responda Si o cualquier otra cosa para No");
                String restringidoLnOtro = ui.readString();
                boolean restringidoOtro;
                if (restringidoLnOtro.toLowerCase().equals("si")) {
                    restringidoOtro = true;
                } else {
                    restringidoOtro = false;
                }

                Otro nuevoOtro = new Otro(descripcionOtro, signaturaOtro, fechaCompraOtro, restringidoOtro, temaOtro);
                gestor.agregarMaterial(nuevoOtro);
                break;

            default:
                break;
        }
    }

    private void listarUsuarios() throws SQLException {
        ui.imprimir("\nEliga el tipo de usuario que desea listar:"
                + "\nPresione 1 para listar los estudiantes"
                + "\nPresione 2 para listar los profesores"
                + "\nPresione 3 para listar los administrativos"
                + "\nPresione 4 para listar todos\n");
        boolean ward = true;
        while (ward) {
            switch (ui.readInt()) {
                case 1:
                    gestor.listarEstudiantes();
                    ward = false;
                    break;
                case 2:
                    gestor.listarProfesores();
                    ward = false;
                    break;
                case 3:
                    gestor.listarAdministrativos();
                    ward = false;
                    break;
                case 4:
                    gestor.listarUsuarios();
                    ward = false;
                    break;
                default:
                    ui.imprimir("\nOpción inválida. Intente de nuevo.\n");
            }
        }

    }

    private void listarMateriales() throws SQLException {
        ui.imprimir("\nEliga el tipo de material que desea listar:"
                + "\nPresione 1 para listar los Textos"
                + "\nPresione 2 para listar los Audios"
                + "\nPresione 3 para listar los Videos"
                + "\nPresione 4 para listar los Otros"
                + "\nPresione 5 para listar todos\n");
        boolean ward = true;
        while (ward) {
            switch (ui.readInt()) {
                case 1:
                    gestor.listarTextos();
                    ward = false;
                    break;
                case 2:
                    gestor.listarAudios();
                    ward = false;
                    break;
                case 3:
                    gestor.listarVideos();
                    ward = false;
                    break;
                case 4:
                    gestor.listarOtros();
                    ward = false;
                    break;
                case 5:
                    gestor.listarMateriales();
                    ward = false;
                    break;
                default:
                    ui.imprimir("\nOpción inválida. Intente de nuevo.\n");
            }
        }
    }

}
