function SignUp({ onBack }) {
    const handleSubmit = (e) => {
        e.preventDefault();
        // Here you would typically send the form data to a backend
        alert('회원가입이 완료되었습니다!');
    };

    return (
        <div style={{ 
            maxWidth: '500px', 
            margin: '40px auto', 
            padding: '30px', 
            borderRadius: '8px',
            boxShadow: '0 2px 10px rgba(0,0,0,0.1)',
            backgroundColor: '#fff'
        }}>
            <h2 style={{ textAlign: 'center', marginBottom: '24px', color: '#333' }}>회원가입</h2>
            
            <form onSubmit={handleSubmit}>
                <div style={{ marginBottom: '16px' }}>
                    <label 
                        htmlFor="username" 
                        style={{ 
                            display: 'block', 
                            marginBottom: '8px', 
                            fontWeight: '500',
                            color: '#555'
                        }}
                    >
                        아이디
                    </label>
                    <input 
                        type="text" 
                        id="username" 
                        required 
                        style={{ 
                            width: '100%', 
                            padding: '10px', 
                            borderRadius: '4px', 
                            border: '1px solid #ddd',
                            fontSize: '16px'
                        }} 
                    />
                </div>
                
                <div style={{ marginBottom: '16px' }}>
                    <label 
                        htmlFor="password" 
                        style={{ 
                            display: 'block', 
                            marginBottom: '8px', 
                            fontWeight: '500',
                            color: '#555'
                        }}
                    >
                        비밀번호
                    </label>
                    <input 
                        type="password" 
                        id="password" 
                        required 
                        style={{ 
                            width: '100%', 
                            padding: '10px', 
                            borderRadius: '4px', 
                            border: '1px solid #ddd',
                            fontSize: '16px'
                        }} 
                    />
                </div>
                
                <div style={{ marginBottom: '16px' }}>
                    <label 
                        htmlFor="confirmPassword" 
                        style={{ 
                            display: 'block', 
                            marginBottom: '8px', 
                            fontWeight: '500',
                            color: '#555'
                        }}
                    >
                        비밀번호 확인
                    </label>
                    <input 
                        type="password" 
                        id="confirmPassword" 
                        required 
                        style={{ 
                            width: '100%', 
                            padding: '10px', 
                            borderRadius: '4px', 
                            border: '1px solid #ddd',
                            fontSize: '16px'
                        }} 
                    />
                </div>
                
                <div style={{ marginBottom: '16px' }}>
                    <label 
                        htmlFor="email" 
                        style={{ 
                            display: 'block', 
                            marginBottom: '8px', 
                            fontWeight: '500',
                            color: '#555'
                        }}
                    >
                        이메일
                    </label>
                    <input 
                        type="email" 
                        id="email" 
                        required 
                        style={{ 
                            width: '100%', 
                            padding: '10px', 
                            borderRadius: '4px', 
                            border: '1px solid #ddd',
                            fontSize: '16px'
                        }} 
                    />
                </div>
                
                <div style={{ marginBottom: '16px' }}>
                    <label 
                        htmlFor="name" 
                        style={{ 
                            display: 'block', 
                            marginBottom: '8px', 
                            fontWeight: '500',
                            color: '#555'
                        }}
                    >
                        이름
                    </label>
                    <input 
                        type="text" 
                        id="name" 
                        required 
                        style={{ 
                            width: '100%', 
                            padding: '10px', 
                            borderRadius: '4px', 
                            border: '1px solid #ddd',
                            fontSize: '16px'
                        }} 
                    />
                </div>
                
                <div style={{ marginBottom: '16px' }}>
                    <label 
                        htmlFor="phone" 
                        style={{ 
                            display: 'block', 
                            marginBottom: '8px', 
                            fontWeight: '500',
                            color: '#555'
                        }}
                    >
                        전화번호
                    </label>
                    <input 
                        type="tel" 
                        id="phone" 
                        required 
                        style={{ 
                            width: '100%', 
                            padding: '10px', 
                            borderRadius: '4px', 
                            border: '1px solid #ddd',
                            fontSize: '16px'
                        }} 
                    />
                </div>
                
                <div style={{ display: 'flex', gap: '10px', marginTop: '24px' }}>
                    <button 
                        type="button" 
                        onClick={onBack}
                        style={{ 
                            flex: 1,
                            padding: '12px', 
                            backgroundColor: '#f0f0f0', 
                            border: 'none', 
                            borderRadius: '4px',
                            cursor: 'pointer',
                            fontSize: '16px',
                            fontWeight: '500'
                        }}
                    >
                        취소
                    </button>
                    <button 
                        type="submit" 
                        style={{ 
                            flex: 1,
                            padding: '12px', 
                            backgroundColor: '#4a90e2', 
                            color: 'white', 
                            border: 'none', 
                            borderRadius: '4px',
                            cursor: 'pointer',
                            fontSize: '16px',
                            fontWeight: '500'
                        }}
                    >
                        가입하기
                    </button>
                </div>
            </form>
        </div>
    );
}

export default SignUp;