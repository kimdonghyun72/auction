function QuickMenu() {
    const icons = [
        { label: '전체카테고리' },
        { label: 'TOP 100' },
        { label: '마이페이지' },
        { label: '경매일정' },
        { label: '이벤트' },
        { label: '공지사항' }
    ];
    return (
        <div style={{ 
            display: 'flex', 
            justifyContent: 'center', 
            gap: 40, 
            margin: '40px 0',
            padding: '20px 0',
            background: '#fafafa',
            borderRadius: 16,
            boxShadow: '0 2px 8px rgba(0,0,0,0.04)'
        }}>
            {icons.map(icon => (
                <a 
                    href="#" 
                    key={icon.label} 
                    style={{ 
                        textAlign: 'center',
                        textDecoration: 'none',
                        transition: 'transform 0.2s ease',
                        display: 'block',
                        padding: '8px 12px',
                        borderRadius: 8
                    }}
                    onMouseOver={(e) => e.currentTarget.style.transform = 'translateY(-4px)'}
                    onMouseOut={(e) => e.currentTarget.style.transform = 'translateY(0)'}
                >
                    <div style={{
                        fontSize: 14,
                        fontWeight: 700,
                        color: '#222',
                        marginTop: 6
                    }}>
                        {icon.label}
                    </div>
                </a>
            ))}
        </div>
    );
}
export default QuickMenu;
