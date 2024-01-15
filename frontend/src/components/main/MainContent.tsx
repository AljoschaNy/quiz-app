import "./MainContent.css";
import OptionCard from "./OptionCard.tsx";

function MainContent() {
    return (
        <main className={"main-content"}>
            <section className={"info-section"}>
                <h1><span className={"intro-text"}>Welcome to the</span> Frontend Quiz!</h1>
                <aside>Pick a subject to get started.</aside>
            </section>

            <section className={"options-container"}>
                <OptionCard imgPath={""} optionText={"HTML"}/>
                <OptionCard imgPath={""} optionText={"CSS"}/>
                <OptionCard imgPath={""} optionText={"Javascript"}/>
                <OptionCard imgPath={""} optionText={"Accessibility"}/>
            </section>

        </main>
    )
}

export default MainContent;
