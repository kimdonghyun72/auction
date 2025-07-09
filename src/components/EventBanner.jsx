function EventBanner() {
    return (
        <div style={{ background: '#222', borderRadius: 16, color: '#fff', padding: 24, minHeight: 320, marginBottom: 16 }}>
            <h4 style={{ marginBottom: 16 }}>9월 vip 온라인 경매</h4>
            <h3 style={{ marginBottom: 16 }}>제100회 새로운 시작</h3>
            <div style={{ fontSize: 15, marginBottom: 16 }}>
                <div>경매 입찰 기간<br />25.07.07(월)~25.09.16(화)</div>
                <div style={{ marginTop: 6 }}>전시기간<br />25.07.14(월) 9시 ~ 25.09.16(화) 18시</div>
            </div>
            <a
                href="https://example.com" // 원하는 링크로 변경
                style={{
                    display: 'inline-block',
                    padding: '8px 24px',
                    borderRadius: 6,
                    background: '#ffe000',
                    color: '#222',
                    fontWeight: 'bold',
                    textDecoration: 'none',
                    marginBottom: 0
                }}
            >
                바로가기
            </a>
            <img src="https://dummyimage.com/180x60/cccccc/000000&text=배너+이미지" alt="배너" style={{ display: 'block', marginTop: 24, borderRadius: 8 }} />
        </div>
    );
}
export default EventBanner;