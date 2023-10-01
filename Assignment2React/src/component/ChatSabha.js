import React, { useEffect, useState } from 'react';
import './ChatSabha.css'; 
const ChatSabha = () => {
  const [socket, setSocket] = useState(null);
  const [message, setMessage] = useState('');
  const [inputMessage, setInputMessage] = useState('');

  useEffect(() => {
    const ws = new WebSocket('wss://socketsbay.com/wss/v2/1/demo/');

    ws.onopen = () => {
      setSocket(ws);
      setMessage('Connected to WebSocket server');
    };

    ws.onmessage = (event) => {
      setMessage(`Received: ${event.data}`);
    };

    ws.onclose = () => {
      setMessage('Connection closed');
    };

    setSocket(ws);

    return () => {
      if (ws) {
        ws.close();
      }
    };
  }, []);

  const handleSendClick = () => {
    if (socket && inputMessage) {
      socket.send(inputMessage);
      setInputMessage('');
    }
  };

  return (
<div className="websocket-demo-container">
  <h2 className="websocket-demo-title">ChatSabha</h2>
  <input
    type="text"
    value={inputMessage}
    onChange={(e) => setInputMessage(e.target.value)}
    className="websocket-demo-input"
    placeholder="Enter message"
  />
  <button onClick={handleSendClick} className="websocket-demo-button">
    Send Message
  </button>
  <p className="websocket-demo-message">{message}</p>
</div>
  );
};


export default ChatSabha;
