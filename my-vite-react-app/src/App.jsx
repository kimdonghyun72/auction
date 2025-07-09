import { useState } from 'react';
import Header from './components/Header';
import SearchBar from './components/SearchBar';
import NavBar from './components/NavBar';
import Carousel from './components/Carousel';
import EventBanner from './components/EventBanner';
import QuickMenu from './components/QuickMenu';
import Footer from './components/Footer';
import HeaderTitle from './components/HeaderTitle';
import SignUp from './components/SignUp';

function App() {
    const [showSignUp, setShowSignUp] = useState(false);

    const handleShowSignUp = () => {
        setShowSignUp(true);
    };

    const handleBackFromSignUp = () => {
        setShowSignUp(false);
    };

    return (
        <div>
            <HeaderTitle />
            <Header onSignUpClick={handleShowSignUp} />

            {showSignUp ? (
                <SignUp onBack={handleBackFromSignUp} />
            ) : (
                <>
                    <SearchBar />
                    <NavBar />
                    <main style={{ display: 'flex', gap: 24, margin: 24 }}>
                        <div style={{ flex: 2 }}>
                            <Carousel />
                        </div>
                        <div style={{ flex: 1 }}>
                            <EventBanner />
                        </div>
                    </main>
                    <QuickMenu />
                </>
            )}

            <Footer />
        </div>
    );
}

export default App;
