import React from 'react'
import { Link } from 'react-router-dom'
import '../styles/Navbar.css'
import Logo from '../assets/Logo.png'

function Navbar() {
    return (
        <div className='navbar'>
            <div className='leftSide'>
                <img src={Logo} alt='Car icon'/>
                <h1>
                    <Link to='/'>Autocritic</Link>
                </h1>
            </div>
            <div className='rightSide'>
                <button className='signUp'>
                    <Link to='/signup'>SIGN UP</Link>
                </button>
            </div>
        </div>
    )
}

export default Navbar
