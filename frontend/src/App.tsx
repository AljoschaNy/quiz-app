import './App.css';
import Header from "./components/header/Header.tsx";
import StartPage from "./components/pages/StartPage.tsx";

function App() {
  return (
    <div className={"main-container"}>
        <Header />
        <StartPage />
    </div>
  );
}

export default App;
