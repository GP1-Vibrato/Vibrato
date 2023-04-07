import { useRef } from "react";
import "../Styles/cadastro.css";
import { FaBars, FaTimes } from "react-icons/fa";
import { useState } from 'react';
import Navbar from "../components/Navbar";
import FooterCL from "../components/FooterCL";



function Home(props) {
    const [inputFields, setInputFields] = useState([
        { name: '', senha: '', email: '', username: '' }
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
                    nome: nome.value,
                    senha: senha.value,
                    email: email.value,
                    username: username.value
                })
            })
            .then(function (res) { console.log(res) })
            .catch(function (res) { console.log(res) })
    }

    return (
        <div>
            <Navbar />
            
            <h1 className="cadastron">Registrar com o e-mail</h1>

            <form>
                {inputFields.map((input, index) => {
                    return (
                        <div className="inputs" key={index}>
                            <div className="row-pai">
                                <p className="row1">Nome Completo
                                    <input type="text" name="nome"  id="nome" onChange={event => handleFormChange(index, event)} />
                                </p>
                                <p className="row2">Username
                                    <input type="text" name="username"  id="username" onChange={event => handleFormChange(index, event)} />
                                </p>
                                <p className="row3">Email
                                    <input type="text" name="nosei"  id="email" onChange={event => handleFormChange(index, event)} />
                                </p>
                            </div>
                            <div className="row-pai2">
                                <p className="row4">Senha
                                    <input type="password" name="senha"  id="senha" onChange={event => handleFormChange(index, event)} />
                                </p>
                               
                                <p className="row5">Confirmar Senha
                                <input type="password" name="email"  id="senha2" onChange={event => handleFormChange(index, event)} />
                                
                                <p className="other-link">É um artista ou produtora? Registre-se clicando AQUI</p>

                                </p>
                            
                            </div>

                        </div>
                    )
                })}
                <button className="btncad" onClick={submit}>Cadastrar</button>
            </form>
            <FooterCL/>
        </div>

    );
}

export default Home;

