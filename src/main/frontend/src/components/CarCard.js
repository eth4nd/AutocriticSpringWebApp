import React from 'react'
import { Link } from 'react-router-dom'
import '../styles/CarCard.css'

function CarCard({ image, name, price }) {
    return (
        <div className='carCard'>
            <div style={{ backgroundImage: `url(${image})`}} className='carImage'> </div>
            <div>
                <h1>{name}</h1>
                <h2>${price.toLocaleString()}</h2>
                <button>
                    <Link to={`/review/`+name}>WRITE A REVIEW</Link>
                </button>
            </div>
        </div>
    )
}

export default CarCard
