import {useParams} from "react-router-dom";
import {useEffect, useState} from "react";
import axios from "axios";
import {Question} from "../../types/types.ts";
import OptionCard from "../main/OptionCard.tsx";

function QuestionPage() {
    const {topicId} = useParams();
    const [questions, setQuestions] = useState<Question[]>([])
    const [selectedOption, setSelectedOption] = useState<string | null>(null);
    const [currentQuestion, setCurrentQuestion] = useState(0);
    const quizAnswers:string[] = ["A","B","C","D"];

    useEffect(() => {
        if(topicId) {
            axios.get<Question[]>("/api/questions/" + topicId)
                .then(response => setQuestions(response.data))
                .catch(error => console.log("error", error))
        }
    }, [topicId])

    function handleClick(option:string) {
        setSelectedOption(option);
    }

    function handleSubmit() {
        currentQuestion < questions.length-1 ? setCurrentQuestion(currentQuestion+1) : alert("finish");
        setSelectedOption(null)
    }

    return questions.length > 0 && (
        <main className={"main-content"}>
            <section className={"info-section"}>
                <p className={"info-text"}>Question 6 of 10</p>
                <h2>{questions[currentQuestion].query}</h2>
                <div className={"progress-bar"}></div>
            </section>

            <section className={"options-container"}>
                {
                    questions[currentQuestion].options.map((option, index) => {
                    return <OptionCard
                        key={questions[currentQuestion]+option}
                        quizAnswer={quizAnswers[index]}
                        optionText={option}
                        isSelected={selectedOption === option}
                        onClick={() => handleClick(option)}
                    />
                })}
                <button className={"option-select"} onClick={handleSubmit}>Submit Answer</button>
            </section>
        </main>
    );
}

export default QuestionPage;