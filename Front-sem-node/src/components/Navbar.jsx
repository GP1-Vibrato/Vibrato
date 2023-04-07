import { useRef } from "react";
import { FaBars, FaTimes } from "react-icons/fa";
import "../Styles/navbar.css";

function Navbar() {
	const navRef = useRef();

	const showNavbar = () => {
		navRef.current.classList.toggle(
			"responsive_nav"
		);
	};

	return (
		<div className="pai">
			<header>
			<h3>Vibrato</h3>

			<nav ref={navRef}>

				<a className="a" href="/#">Home</a>
	
				<a className="b" href="/#">Serviços</a>
			
				<a className="c" href="/#">Echo</a>

				<a className="d" href="/#">Contato</a>

				<p draggable>|</p>

				<a className="login" href="/login">Login</a>
				<a  href="/cadastro">

				<button className="cadastrar">Cadastrar</button>
				</a>
			
			</nav>

			
		</header>
		<button
				className="nav-btn"
				onClick={showNavbar}>
				<FaBars />
			</button>
		</div>

);
}

export default Navbar;
