import React from 'react'
import Navbar from './components/Navbar'
import Footer from './components/Footer'
import Home from './pages/Home'
import SignUp from './pages/SignUp'
import Review from './pages/Review'
import AddCar from './pages/AddCar'
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
            <Route path='/review/:name' element={<Review />} />
            <Route path ='/addCar' element={<AddCar/>}/>
          </Routes>
          <Footer />
        </Router>
      </div>
  )
}

export default App
