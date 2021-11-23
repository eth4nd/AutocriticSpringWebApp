import React from 'react'
import { Link } from 'react-router-dom'
import '../styles/Navbar.css'

function Navbar() {
    return (
        <div className='navbar'>
            <div className='leftSide'>
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
