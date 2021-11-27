import React from 'react'
import { CarList } from '../helpers/CarList'
import CarCard from '../components/CarCard'
import '../styles/Home.css'

function Home() {
    return (
        <div className='home'>
            <div className='headerContainer'>
                <p>You are at the Home page</p>
                <h1>Choose a car to review</h1>
            </div>
            <div className='carList'>
                {CarList.map((car, key) => {
                    return (
                        <CarCard
                            key={key}
                            image={car.image}
                            name={car.name}
                            price={car.price}
                        />
                    )
                })}
            </div>
        </div>
    )
}

export default Home
