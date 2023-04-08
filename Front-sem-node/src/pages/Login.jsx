import { useRef } from "react";
import { FaBars, FaTimes } from "react-icons/fa";
import { useState } from 'react';
import Navbar from "../components/Navbar";
import "../Styles/login.css";
import FooterCL from "../components/FooterCL";


function Home(props) {
    const [inputFields, setInputFields] = useState([
        { senha: '', email: '' }
    ])
    const handleFormChange = (index, event) => {
        let data = [...inputFields];
        data[index][event.target.name] = event.target.value;
        setInputFields(data);
    }

    const submit = (e) => {
        e.preventDefault();
        fetch("http://localhost:8080/artistas",
            {
                headers: {
                    'Accept': 'application/json',
                    'Content-Type': 'application/json'
                },
                method: "POST",
                body: JSON.stringify({
                    senha: senha.value,
                    email: email.value,

                })
            })
            .then(function (res) { console.log(res) })
            .catch(function (res) { console.log(res) })
    }

    return (
        <div>
            <Navbar />

            <h1 className="Login">Iniciar Sessão</h1>

            <form>
                {inputFields.map((input, index) => {
                    return (
                        <div className="inputs" key={index}>
                            <div className="pai-login">
                                <p className="login-user">E-mail
                                    <input type="text" name="email" id="email-login" onChange={event => handleFormChange(index, event)} />
                                </p>
                                <p className="login-senha">Senha
                                    <input type="text" name="nosei" id="senha-login" onChange={event => handleFormChange(index, event)} />
                                    <p className="other-link2">Não tem uma conta? Resgistre-se AQUI</p>

                                </p>
                            </div>
                        </div>
                    )
                })}
                <button className="btncad-login" onClick={submit}>Entrar</button>
            </form>
            <FooterCL />

        </div>

    );
}

export default Home;

