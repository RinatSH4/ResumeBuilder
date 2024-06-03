function submitResume() {
    const formData = new FormData(document.getElementById('resumeForm'));
    fetch('/api/resumes/create', {
        method: 'POST',
        body: formData
    })
        .then(response => {
            if (!response.ok) {
                throw new Error('Error creating resume');
            }
            return response.json();
        })
        .then(data => {
            // Обработка успешного создания резюме
        })
        .catch(error => {
            console.error('Error:', error);
        });
}


(function() {
    async function submitResume() {
        const form = document.getElementById('resumeForm');
        const formData = new FormData(form);

        // Сначала создаем резюме
        const resumeResponse = await fetch('/api/resume/create', {
            method: 'POST',
            body: JSON.stringify(Object.fromEntries(formData)),
            headers: {
                'Content-Type': 'application/json'
            }
        });

        if (!resumeResponse.ok) {
            console.error('Error creating resume');
            return;
        }

        const resumeData = await resumeResponse.json();
        const resumeId = resumeData.id;

        // Затем выбираем формат
        const format = formData.get('format');
        const formatResponse = await fetch('/api/resume/' + resumeId + '/format?format=' + format, {
            method: 'POST'
        });

        if (formatResponse.ok) {
            const blob = await formatResponse.blob();
            const url = window.URL.createObjectURL(blob);
            const a = document.createElement('a');
            a.href = url;
            a.download = 'resume.' + format;
            document.body.appendChild(a);
            a.click();
            a.remove();
        } else {
            console.error('Error generating resume in selected format');
        }
    }

    document.getElementById('resumeForm').addEventListener('submit', function(event) {
        event.preventDefault();
        submitResume();
    });
})();
