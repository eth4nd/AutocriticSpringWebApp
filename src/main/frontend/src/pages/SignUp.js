import React from 'react'
import '../styles/SignUp.css'

function SignUp() {
    return (
        <div className='signup'>
            <div className='headerContainer'>
                <p>You are at the Sign Up page</p>
                <h1>Sign up to start reviewing</h1>
            </div>
            <div className='menuContainer'>
                <form className='signupMenu' action='/'>
                    <p>Don't have an account? Sign up below.</p>
                    <label htmlFor='username'>Username</label>
                    <input type='text' id='username' />
                    <label htmlFor='password'>Password</label>
                    <input type='text' id='password' />
                    <input className='signupButton' type='submit' value='SIGN UP' />
                </form>
                <form className='loginMenu' action='/'>
                    <p>Already have an account? Log in below.</p>
                    <label htmlFor='username'>Username</label>
                    <input type='text' id='username' />
                    <label htmlFor='password'>Password</label>
                    <input type='text' id='password' />
                    <input className='loginButton' type='submit' value='LOG IN' />
                </form>
            </div>
        </div>
    )
}

export default SignUp
