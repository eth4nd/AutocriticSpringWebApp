import React from 'react'
import Navbar from './components/Navbar'
import Footer from './components/Footer'
import Home from './pages/Home'
import SignUp from './pages/SignUp'
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom'
import './App.css'

function App() {
  return (
      //Render the Navbar and Footer outside of Routes so they appear on all pages
      <div className="App">
        <Router>
          <Navbar />
          <Routes>
            <Route path='/' element={<Home />} />
            <Route path='/signup' element={<SignUp />} />
          </Routes>
          <Footer />
        </Router>
      </div>
  )
}

export default App
