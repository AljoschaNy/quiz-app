import './App.css';
import Header from "./components/header/Header.tsx";
import MainContent from "./components/main/MainContent.tsx";

function App() {
  return (
    <div className={"main-container"}>
        <Header />
        <MainContent />
    </div>
  );
}

export default App;
