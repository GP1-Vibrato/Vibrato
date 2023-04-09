import { useRef } from "react";
import { FaBars, FaTimes } from "react-icons/fa";
import "../Styles/footercl.css";

function FooterCL() {


    return (
        <div className="footercl">
            <div className="footer-vo">
                <div className="footer-pai1">
                    <h2 className="footer-filhog" draggable>CONTA</h2>

                    <a className="deco-footer" href="/login">
                        <h4 className="footer-filho" draggable>Entrar</h4></a>
                    <a className="deco-footer" href="/cadastro">
                        <h4 className="footer-filho" draggable>Registrar-se</h4></a>

                </div>
                <div className="footer-pai2">
                    <h2 className="footer-filhog" draggable>ECHO</h2>

                    <a className="deco-footer" href="/login">
                        <h4 className="footer-filho" draggable>Echo</h4> </a>
                    <a className="deco-footer" href="/login">
                        <h4 className="footer-filho" draggable>Suporte Echo</h4> </a>
                    <a className="deco-footer" href="/login">
                        <h4 className="footer-filho" draggable>Recursos</h4> </a>

                </div>
                <div className="footer-pai">
                    <h2 className="footer-filhog" draggable>SIGA-NOS</h2>

                    <a className="deco-footer" href="/login">
                        <h4 className="footer-filho" draggable>Facebook</h4></a>
                    <a className="deco-footer" href="/login">
                        <h4 className="footer-filho" draggable>Instagram</h4></a>
                    <a className="deco-footer" href="/login">
                        <h4 className="footer-filho" draggable>Twitter</h4></a>
                    <a className="deco-footer" href="/login">
                        <h4 className="footer-filho" draggable>Playlist Spotify</h4></a>

                </div>
            </div>
            <hr />
            <div className="final-footer" draggable>Copyright @PROXMOOV. All Rights Reserved.</div>

        </div>
    );
}

export default FooterCL;
